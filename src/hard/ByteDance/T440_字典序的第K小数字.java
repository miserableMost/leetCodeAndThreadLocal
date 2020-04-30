package hard.ByteDance;

/**
 * @author 李聪
 * @date 2020/3/28 19:21
 *
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * 示例 :
 *
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 */
public class T440_字典序的第K小数字 {
    public static void main(String[] args) {
        T440_字典序的第K小数字 test = new T440_字典序的第K小数字();
        test.findKthNumber(13,2);
    }
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k -= 1;
        while(k > 0) {
            //计算每一层的节点数
            int step = count(n,cur,cur + 1);
            //如果不在这一层，需要深入一层
            if(step <= k) {
                k -= step;
                cur ++;
                //在这一层,继续扩大前缀范围
            }else {
                cur *= 10;
                k --;
            }
        }
        return cur;
    }

    /**
     * 你可能会问:咦？怎么是 n+1 ,而不是 nnn 呢？不是说好了 nnn 是上界吗？
     *
     * 我举个例子，假若现在上界 nnn为 12，算出以 1 为前缀的子节点数，首先 1 本身是一个节点，接下来要算下面 10，11，12，一共有 4 个子节点。
     *
     * 那么如果用 Math.min(n,next)−curMath.min(n, next) - curMath.min(n,next)−cur 会怎么样？
     *
     * 这时候算出来会少一个，12 - 10 加上根节点，最后只有 3 个。因此我们务必要写 n+1。
     *
     * 现在，我们搞定了前缀的子节点数问题。
     *
     * @param n
     * @param first
     * @param second
     * @return
     */
    private int count(int n,long first,long second) {
        int ans = 0;
        while(first <= n) {
            //可以理解之前的都是左闭右开，最后将右开的加上1
            ans += Math.min(second,n + 1) - first;
            first *= 10;
            second *= 10;
        }
        return ans;
    }
}
