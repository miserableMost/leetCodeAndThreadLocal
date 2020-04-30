package hard.ByteDance;

import java.util.PriorityQueue;

/**
 * @author 李聪
 * @date 2020/4/9 17:25
 * 给你一个 m x n 的矩阵，其中的值均为正整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * 示例：
 *
 * 给出如下 3x6 的高度图:
 * [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 *
 * 返回 4 。
 *接雨水I中，我们维护了左右两个最高的墙，那么在这里，就是维护周围一个圈，用堆来维护周围这一圈中的最小元素。为什么是维护最小的元素不是最大的元素呢，因为木桶原理呀。这个最小的元素从堆里弹出来，和它四个方向的元素去比较大小，看能不能往里灌水，怎么灌水呢，如果用方向就比较复杂了，我们可以用visited数组来表示哪些遍历过，哪些没遍历过。如果当前弹出来的高度比它周围的大，那就是能灌水，把下一个柱子放进去的时候，放的高度要取两者较大的，也就是灌水后的高度，而不是它原来矮的高度了，如果不能灌水，继续走
 *
 * 作者：jerry_nju
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water-ii/solution/you-xian-dui-lie-de-si-lu-jie-jue-jie-yu-shui-ii-b/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class T407_接雨水2 {

    public static void main(String[] args) {

    }
    //先把最外围的一圈作为围栏， 选择一个最低的围栏， 如果这个围栏的邻节点都比它大， 此围栏可删除，邻节点作为新的围栏；
    // 如果邻节点比它小， 那么邻节点可储蓄的水为 二者高度之差， 此时在邻节点设置围栏，高度为当前围栏高度即可。
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0)
            return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        //定义一个数组用来判断是否访问过
        boolean[][] vistied = new boolean[m][n];
        //定义一个三维数组用来存储高度,用小顶堆存储
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[2] - o2[2]);
        //先放外围一圈
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    queue.add(new int[] {i,j,heightMap[i][j]});
                    vistied[i][j] = true;
                }
            }
        }
        int res = 0;
        //用来方向的数组
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()) {
            //得到弹出的数组
            int[] poll = queue.poll();
            //从外层进行突破
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dir[k][0];
                int ny = poll[1] + dir[k][1];
                //边界限制
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || vistied[nx][ny])
                    continue;
                // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                if(heightMap[nx][ny] < poll[2]) {
                   res += poll[2] - heightMap[nx][ny];
                }
                queue.add(new int[]{nx,ny,Math.max(poll[2],heightMap[nx][ny])});
                vistied[nx][ny] = true;
            }
        }
        return res;
    }
}
