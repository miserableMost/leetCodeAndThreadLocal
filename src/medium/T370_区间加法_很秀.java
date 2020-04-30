package medium;

/**
 * @author 李聪
 * @date 2020/4/14 22:21
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k​​​​​​​ 个更新的操作。
 *
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 *
 * 请你返回 k 次操作后的数组。
 *
 * 示例:
 *
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 *
 * 解释:
 *
 * 初始状态:
 * [0,0,0,0,0]
 *
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 *
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 *
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 *
 */
public class T370_区间加法_很秀 {
    public static void main(String[] args) {

    }

    /**
     * 方法一：差分数组
     *
     * 如果我们知道每一个元素比前一个元素大多少，以及第一元素的值，我们就可以 O(n)O(n)O(n) 遍历数组求出所有数的值。举个例子，我们已知 a1=3a_1=3a1​=3 ，a2a_2a2​ 比 a1a_1a1​ 大 5，则我们可以知道 a2=a1+5=8a_2=a_1+5=8a2​=a1​+5=8 。
     *
     * 回到题目本身，每个操作其实代表了这样两个事情：
     *
     *     astartIndexa_{startIndex}astartIndex​ 比前一个元素多了 incincinc 。
     *     aendIndex+1a_{endIndex + 1}aendIndex+1​ 比前一个元素少了 incincinc 。
     *
     * 则我们可以建立一个差分数组 bbb 表示元素间的差值，即 bi=ai−ai−1b_i=a_i-a_{i-1}bi​=ai​−ai−1​ ，则刚刚的操作就等价于：
     *
     *     bstartIndex+=incb_{startIndex} += incbstartIndex​+=inc 。
     *     bendIndex+1−=incb_{endIndex+1} -= incbendIndex+1​−=inc 。
     *
     * 最后我们用 bbb 数组求出 aaa 数组，即为我们要的答案。
     *
     * @param length
     * @param updates
     * @return
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] u : updates) {
            res[u[0]] += u[2];
            if(u[1] + 1 < length)
                res[u[1] + 1] -= u[2];
        }
        for (int i = 1; i < length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
