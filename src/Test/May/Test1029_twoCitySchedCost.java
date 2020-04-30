package Test.May;

import java.util.Arrays;
import java.util.Comparator;

/** leetCode 1029:两地调度
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 */
public class Test1029_twoCitySchedCost {
    public static void main(String[] args) {
        int[][] costs = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(twoCitySchedCost(costs));
    }
    //此题基于贪心思想：对cost(A) - cost(B）差值排序，前N小的差值去A花费最小，
    // 后面N个你反过来想，就是去B花费最小(比如排序方式变成cost(B) - cost(A))
    public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            //两个数组怎么排序
            public int compare(int[] o1, int[] o2) {
                //看哪个数组的元素差更大
                return (o1[0]-o1[1]) - (o2[0]-o2[1]);
            }
        });
        int count = 0;
        for (int i = 0; i < costs.length; i++) {
            count += costs[i][i < costs.length/2 ? 0:1];
        }
        return count;
    }
}
