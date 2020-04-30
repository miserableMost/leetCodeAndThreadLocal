package Test.May;

import java.util.HashMap;

/**leetCode 477 回旋镖的数量
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
 * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * 示例:
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * 输出:
 * 2
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class Test477_numberOfBoomerangs {
    public static void main(String[] args) {
        int [][] points = {{0,0},{1,0},{2,0}};
        System.out.println(numberOfBoomerangs(points));
    }




    public static int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int count = 0;
        HashMap<Double,Integer> map = new HashMap<>();
        //计算长度
        for (int i = 0; i < len; i++) {
            for(int j = 0;j < len;j++){
                if(i != j){
                    //计算长度
                    double dis = Math.pow(points[i][0] - points[j][0],2) + Math.pow(points[i][1] - points[j][1],2);
                    if(!map.containsKey(dis)){
                        map.put(dis,1);
                    }else{
                        int n = map.get(dis);
                        /**
                         * 若同一距离出现多次，则可以形成回旋镖。假设同一距离出现 n 次，
                         * 由数字规律可推出回旋镖的数量 sum = n*(n-1) 。本人开始只能做到存储到哈希表，
                         * 然后按该公式累加得到最后结果。参考了速度第一的答案，优化如下：
                         * 假设当前同一距离的数量为 n,
                         * 回旋镖数量为 n*(n-1), 当再出现一个同一距离时，回旋镖的数量应为 (n+1)*n，
                         * 与之前相差 (n+1)*n - n*(n-1) = 2*n， 所以只需要把最后答案加上 2*n,
                         * 最后 n+1 再存储到哈希表中。
                         */
                        count += 2 * n;
                        map.put(dis,n+1);
                    }
                }
            }
            map.clear();

        }

        return count;
    }
}
