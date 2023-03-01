package Maze;

/**
 * 描述: 定义迷宫节点类型
 */
public class MazeNode {
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
