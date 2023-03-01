package GA;

public class GAA {

    private final int ChrNum = 100;	//染色体数量
    private String[] ipop = new String[ChrNum];	 	//一个种群中染色体总数
    private int generation = 0; 	//染色体代号
    public static final int GENE = 36; 		//基因数
    private double bestfitness = Double.MAX_VALUE;  //函数最优解
    private int bestgenerations;   	//所有子代与父代中最好的染色体
    private String beststr;   		//最优解的染色体的二进制码
    private final double [][]Q={{800,800},{600,600},{600,600},{700,700}};//饱和车流量为1200pcu/h
    private final double [][]X={{0.67,0.67},{0.5,0.5},{0.5,0.5},{0.583,0.583}};


    /**
     * 初始化一条染色体（用二进制字符串表示）
     */
    private String initChr() {
        String res = "";
        for (int i = 0; i < GENE; i++) {
            if (Math.random() < 0.50){
                res += "1";}
            else {
                res += "0";}
        }
        return res;
    }

    /**
     * 初始化一个种群(100条染色体)
     */
    private String[] initPop() {
        String[] ipop = new String[ChrNum];
        for (int i = 0; i < ChrNum; i++) {
            ipop[i] = initChr();
        }
        return ipop;
    }

    /**
     * 将染色体转换成十进制变量的值
     */
    private double[] calculatefitnessvalue(String str) {

        int b1 = Integer.parseInt(str.substring(0, 12), 2);
        int b2 = Integer.parseInt(str.substring(12, 24), 2);
        int b3 = Integer.parseInt(str.substring(24, 36), 2);
        //int b4 = Integer.parseInt(str.substring(30, 40), 2);

        double y1 =  b1 * (20.0 - 0.0) / (Math.pow(2, 12) - 1);    //y1的基因
        double y2 =  b2 * (20.0 - 0.0) / (Math.pow(2, 12) - 1);    //y2的基因
        double y3 =  b3 * (20.0 - 0.0) / (Math.pow(2, 12) - 1);    //y3的基因
        //double y4 =  b4 * (20.0 - 0.0) / (Math.pow(2, 10) - 1);    //y4的基因

        //需优化的函数
        double g=0,f=0;
        for(int j=0;j<2;j++)
        {
            double y4=80-y1-y2-y3;
            f=f+(Q[0][j]*(y1+y2+y3+y4)*(1-y1/(y1+y2+y3+y4))*(1-y1/(y1+y2+y3+y4)))/(2*(1-(y1/(y1+y2+y3+y4))*X[0][j]))+(X[0][j]*X[0][j])/(2*(1-X[0][j]))
                    +(Q[1][j]*(y1+y2+y3+y4)*(1-y2/(y1+y2+y3+y4))*(1-y2/(y1+y2+y3+y4)))/(2*(1-(y2/(y1+y2+y3+y4))*X[1][j]))+(X[1][j]*X[1][j])/(2*(1-X[1][j]))
                    +(Q[2][j]*(y1+y2+y3+y4)*(1-y3/(y1+y2+y3+y4))*(1-y3/(y1+y2+y3+y4)))/(2*(1-(y3/(y1+y2+y3+y4))*X[2][j]))+(X[2][j]*X[2][j])/(2*(1-X[2][j]))
                    +(Q[3][j]*(y1+y2+y3+y4)*(1-y4/(y1+y2+y3+y4))*(1-y4/(y1+y2+y3+y4)))/(2*(1-(y4/(y1+y2+y3+y4))*X[3][j]))+(X[3][j]*X[3][j])/(2*(1-X[3][j]));
            for(int i=0;i<4;i++)
                g=g+Q[i][j];
        }
        double fitness = f/g;

        double[] returns = { y1,y2,y3,65-y1-y2-y3,fitness };
        return returns;
    }

    //排序
    public static void orderNum(double[] n) {
        for (int i = 0; i < n.length - 1; i++)
        { for (int j = 0; j < n.length - 1 - i; j++)
            { double temp = 0;
                 if (n[j] < n[j + 1])
                 {   temp = n[j + 1];
                     n[j + 1] = n[j];
                     n[j] = temp;
                 }
            }
        }
    }
    /**
     * 轮盘选择
     * 计算群体上每个个体的适应度值;
     * 按由个体适应度值所决定的某个规则选择将进入下一代的个体;
     */
    private void select() {
        double evals[] = new double[ChrNum]; // 所有染色体适应值
        double p[] = new double[ChrNum]; // 各染色体选择概率
        double q[] = new double[ChrNum]; // 累计概率
        double F = 0; // 累计适应值总和
        for (int i = 0; i < ChrNum; i++) {
            evals[i] = calculatefitnessvalue(ipop[i])[4];
            if (evals[i] < bestfitness){  // 记录下种群中的最小值，即最优解
                bestfitness = evals[i];
                bestgenerations = generation;
                beststr = ipop[i];
                System.out.println(calculatefitnessvalue(beststr)[4]);
            }
            //System.out.println(calculatefitnessvalue(beststr)[4]);
            F = F + evals[i]; // 所有染色体适应值总和
        }

        for (int i = 0; i < ChrNum; i++) {
            p[i] = evals[i] / F;
        }
        orderNum(p);
        for (int i = 0; i < ChrNum; i++) {
            if (i == 0)
                q[i] = p[i];
            else {
                q[i] = q[i - 1] + p[i];
            }
        }
        for (int i = 0; i < ChrNum; i++) {
            double r = Math.random();
            if (r <= q[0]) {
                ipop[i] = ipop[0];
            } else {
                for (int j = 1; j < ChrNum; j++) {
                    if (r < q[j]) {
                        ipop[i] = ipop[j];
                    }
                }
            }
        }
    }

    /**
     * 交叉操作 交叉率为60%，平均为60%的染色体进行交叉
     */
    private void cross() {
        String temp1, temp2;
        for (int i = 0; i < ChrNum; i++) {
            if (Math.random() < 0.60) {
                int pos = (int)(Math.random()*GENE)+1;     //pos位点前后二进制串交叉
                temp1 = ipop[i].substring(0, pos) + ipop[(i + 1) % ChrNum].substring(pos);
                temp2 = ipop[(i + 1) % ChrNum].substring(0, pos) + ipop[i].substring(pos);
                ipop[i] = temp1;
                ipop[(i + 1) % ChrNum] = temp2;
            }
        }
    }

    /**
     * 基因突变操作 1%基因变异
     */
    private void mutation() {
        for (int i = 0; i < 4; i++) {
            int num = (int) (Math.random() * GENE * ChrNum + 1);
            int chromosomeNum = (int) (num / GENE) + 1; // 染色体号

            int mutationNum = num - (chromosomeNum - 1) * GENE; // 基因号
            if (mutationNum == 0)
                mutationNum = 1;
            chromosomeNum = chromosomeNum - 1;
            if (chromosomeNum >= ChrNum)
                chromosomeNum = 9;
            String temp;
            String a;   //记录变异位点变异后的编码
            if (ipop[chromosomeNum].charAt(mutationNum - 1) == '0') {    //当变异位点为0时
                a = "1";
            } else {
                a = "0";
            }
            //当变异位点在首、中段和尾时的突变情况
            if (mutationNum == 1) {
                temp = a + ipop[chromosomeNum].substring(mutationNum);
            } else {
                if (mutationNum != GENE) {
                    temp = ipop[chromosomeNum].substring(0, mutationNum -1) + a
                            + ipop[chromosomeNum].substring(mutationNum);
                } else {
                    temp = ipop[chromosomeNum].substring(0, mutationNum - 1) + a;
                }
            }
            //记录下变异后的染色体
            ipop[chromosomeNum] = temp;
        }
    }

    public static void main(String args[]) {

        GAA Tryer = new GAA();
        Tryer.ipop = Tryer.initPop(); //产生初始种群
        String str = "";

        System.out.println("平均延误变化如下：");
        //迭代次数
           for (int i = 0; i < 100000; i++) {
               Tryer.select();
               Tryer.cross();
               Tryer.mutation();
               Tryer.generation = i;
           }

        double[] x = Tryer.calculatefitnessvalue(Tryer.beststr);

        str = "最小值" + Tryer.bestfitness + '\n' + "第"
                + Tryer.bestgenerations + "个染色体:<" + Tryer.beststr + ">" + '\n'
                + "总周期时长为：" + 65 + '\n' + "相位1的绿灯时长为：" + x[0] +'\n'+ "相位2的绿灯时长为：" + x[1] +'\n'
                + "相位3的绿灯时长为：" + x[2] +'\n'+ "相位4的绿灯时长为：" + x[3] +'\n'+ "平均延误为：" + x[4];

        System.out.println(str);

    }
}
