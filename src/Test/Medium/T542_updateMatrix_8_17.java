package Test.Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetCode 542 : 01矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 * 基本思路：广度优先算法（BFS）
 *
 * 首先，既然是使用广度优先算法，自然想到了借助队列实现。需要进行第一次遍历，初始化队列，找出数组中所有值为0的坐标，
 * 并将其保存至队列中，若值非0，则赋予最大值10001（因为数组最多有10000个元素）。当该次遍历结束后，数组中原来为0的值保持不变，
 * 原来为1的值被改为最大值10001，队列中保存有所有原来值为0的坐标，这是第一批次的坐标节点。
 *
 * 然后，对队列中的节点按批次进行处理，遍历队列中的节点，进行处理，处理方法为：再次遍历该节点的上下左右四个合法的邻居节点，
 * 若邻居节点的值为最大值10001，则说明该邻居节点未曾处理，将其添加到队列中，等待下一批次处理，
 * 并计算出四个邻居节点和自身节点的最小值min，最后进行赋值。
 *
 * 当队列为空时，全部节点遍历完毕，得出最终答案
 *
 */
public class T542_updateMatrix_8_17 {
    private int[][] neighborVals = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    private Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) {
        int[][] test = {{0,1,1},{1,1,1},{1,1,0}};
        T542_updateMatrix_8_17 t = new T542_updateMatrix_8_17();
        int[][] ints = t.updateMatrix(test);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }


    public int[][] updateMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0)
                    queue.offer(new int[]{i, j});
                else
                    matrix[i][j] = 10001;
            }
        }
        while(!queue.isEmpty()){
            int len = queue.size();
            while(len > 0){
                len--;
                int[] temp = queue.poll();
                neighbor(matrix, temp[0], temp[1]);
            }
        }
        return matrix;
    }

    // 处理邻居节点
    private void neighbor(int[][] matrix, int x, int y) {
        int min = matrix[x][y];
        // 先通过遍历该节点的邻居节点，找到最小邻居值并将未使用过的邻居节点添加至队列中
        for (int[] neighborVal : neighborVals) {
            int xx = x + neighborVal[0];
            int yy = y + neighborVal[1];
            if (xx >= 0 && xx < matrix.length && yy >= 0 && yy < matrix[0].length) {
                min = Math.min(matrix[xx][yy] + 1, min);
                if (matrix[xx][yy] == 10001)
                    queue.offer(new int[]{xx, yy});
            }
        }
        matrix[x][y] = min;
    }
}
