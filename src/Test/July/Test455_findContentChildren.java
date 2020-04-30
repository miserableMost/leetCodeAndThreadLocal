package Test.July;

import java.util.Arrays;

/**
 * leetCode 455 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 注意：
 *
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 输入: [1,2,3], [1,1]
 输出: 1
 解释:
 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 所以你应该输出1。
 */
public class Test455_findContentChildren {
    public static void main(String[] args) {
         int[] a = {1,2};
         int[] b = {1,2,3};
        System.out.println(findContentChildren(a,b));
    }

   //效率太低
   /* public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        //定义返回结果
        int count = 0;
        int temp = 0;
        for (int i = 0; i < g.length; i++) {

            for (int j = temp; j < s.length; j++) {
                if(g[i] <= s[j]){
                    count ++ ;
                    //记下能满足这个小孩的饼干的位置
                    temp = j + 1;
                    break;
                }
            }
        }
        return count;

    }*/
    public static int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        //定义两个指针
        int a = 0,b = 0;
        while(a < g.length && b < s.length){
            //能满足
            if(g[a] <= s[b]){
                count ++;
                a++;
                b++;
            }else{
                b++;
            }
        }
        return count;
    }
}
