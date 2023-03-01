package Maze;


/**
 * 描述: 迷宫的类型定义
 */
public class Maze {
    // 迷宫所有的路径存储在二维数组当中
    private MazeNode[][] maze;
    // 存储迷宫路径节点的队列结构，采用层层扩张的方式，寻找迷宫最优的路径信息
    private LinkQueue<MazeNode> queue;
    // 记录迷宫路径节点的行走信息
    private MazeNode[] pathrecord;
    // 迷宫的行数
    private int row;
    // 迷宫的列数
    private int col;

    /**
     * 迷宫初始化
     * @param row
     * @param col
     */
    public Maze(int row, int col) {
        this.row = row;
        this.col = col;
        this.maze = new MazeNode[row][col];
        this.queue= new LinkQueue<MazeNode>();
        this.pathrecord = new MazeNode[row*col];
    }


    /**
     * 初始化指定位置的迷宫节点
     * @param data
     * @param i
     * @param j
     */
    public void initMazeNode(int data, int i, int j) {
        this.maze[i][j] = new MazeNode(data, i, j);
    }

    /**
     * 修改迷宫所有节点四个方向的行走状态信息
     */
    public void initMazeNodePathState() {
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if(j+1<col&&maze[i][j+1].val==0){
                    maze[i][j].state[Constant.RIGHT]=true;
                }
                if(i+1<row&&maze[i+1][j].val==0){
                    maze[i][j].state[Constant.DOWN]=true;
                }
                if(j>0&&maze[i][j-1].val==0){
                    maze[i][j].state[Constant.LEFT]=true;
                }
                if(i>0&&maze[i-1][j].val==0){
                    maze[i][j].state[Constant.UP]=true;
                }
            }
        }
    }

    /**
     * 寻找迷宫路径
     */
    public void findMazePath() {
        if (maze[0][0].val != 0) {
            return;
        }
        queue.offer(maze[0][0]);
        while(!queue.isEmpty()){
            MazeNode top = queue.peek();
            int x = top.x;
            int y = top.y;
            if(x == row-1 && y == col-1){
                return;
            }

            // 往右方向走
            if(maze[x][y].state[Constant.RIGHT]){
                maze[x][y].state[Constant.RIGHT] = false;
                maze[x][y+1].state[Constant.LEFT] = false;
                queue.offer(maze[x][y+1]);
                pathrecord[x*col+y+1] = maze[x][y];
            }

            // 往下方向走
            if(maze[x][y].state[Constant.DOWN]){
                maze[x][y].state[Constant.DOWN] = false;
                maze[x+1][y].state[Constant.UP] = false;
                queue.offer(maze[x+1][y]);
                pathrecord[(x+1)*col+y] = maze[x][y];
            }

            // 往左方向走
            if(maze[x][y].state[Constant.LEFT]){
                maze[x][y].state[Constant.LEFT] = false;
                maze[x][y-1].state[Constant.RIGHT] = false;
                queue.offer(maze[x][y-1]);
                pathrecord[x*col+y-1] = maze[x][y];
            }
            // 往上方向走
            if(maze[x][y].state[Constant.UP]){
                maze[x][y].state[Constant.UP] = false;
                maze[x-1][y].state[Constant.DOWN] = false;
                queue.offer(maze[x-1][y]);
                pathrecord[(x-1)*col+y] = maze[x][y];
            }

            queue.poll();
        }
    }
    /**
     * 打印迷宫路径搜索的结果
     */
    public void showMazePath(){

        if(pathrecord[row*col-1] == null){
            System.out.println("迷宫不存在有效路径");
        } else {
            int x = row-1;
            int y = col-1;
            for(;;){
                maze[x][y].val = '*';
                MazeNode node = pathrecord[x*col+y];
                if(node == null){
                    break;
                }
                x = node.x;
                y = node.y;
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(maze[i][j].val == '*'){
                        System.out.print('*' + " ");
                    } else {
                        System.out.print(maze[i][j].val + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * 描述: 定义迷宫节点类型
     */
    private static class MazeNode {
        // 节点的值
        int val;
        // 节点的x和y坐标
        int x;
        int y;
        // 节点四个方向的行走状态，true表示可以走，false表示不能走
        boolean[] state;

        /**
         * 迷宫路径初始化
         * @param data
         * @param i
         * @param j
         */
        public MazeNode(int data, int i, int j){
            this.state = new boolean[4];
            this.val = data;
            this.x = i;
            this.y = j;
        }
    }
}
