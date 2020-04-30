package Test.August;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 1128:等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 */
public class D5_numEquivDominoPairs_1128 {
    public static void main(String[] args) {
        int[][] dom = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(numEquivDominoPairs(dom));
    }
    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<String,Integer> map = new HashMap<>();
        int count = 0;
        for (int[] dom : dominoes) {
            /*Map<Integer,Integer> temp = new HashMap<>();*/

            int max = 0,min = 0;
            if(dom[0] > dom[1]){
                max = dom[0];
                min = dom[1];
            }else{
                max = dom[1];
                min = dom[0];
            }
            //将诺骨牌用字符串表示
            String temp = max + "-" + min;
            map.put(temp,map.getOrDefault(temp,0) + 1);

        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int p = entry.getValue();
            if(p > 1)
                count += p * (p - 1) / 2;

        }

        return count;
    }
   /* public int jiecheng(int n){
        int t = 1;
        for (int i = 1; i <= n; i++) {
            t = t * i;
        }
        return t;
    }*/
}
