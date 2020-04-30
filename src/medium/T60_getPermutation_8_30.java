package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 60 : 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 */
public class T60_getPermutation_8_30 {
    public static void main(String[] args) {
        String s = getPermutation(3, 3);
        System.out.println(s);
    }
    /**
     直接用回溯法做的话需要在回溯到第k个排列时终止就不会超时了, 但是效率依旧感人
     可以用数学的方法来解, 因为数字都是从1开始的连续自然数, 排列出现的次序可以推
     算出来, 对于n=4, k=15 找到k=15排列的过程:

     1 + 对2,3,4的全排列 (3!个)
     2 + 对1,3,4的全排列 (3!个)         3, 1 + 对2,4的全排列(2!个)
     3 + 对1,2,4的全排列 (3!个)-------> 3, 2 + 对1,4的全排列(2!个)-------> 3, 2, 1 + 对4的全排列(1!个)-------> 3214
     4 + 对1,2,3的全排列 (3!个)         3, 4 + 对1,2的全排列(2!个)         3, 2, 4 + 对1的全排列(1!个)

     确定第一位:
     k = 14(从0开始计数)
     index = k / (n-1)! = 2, 说明第15个数的第一位是3
     更新k
     k = k - index*(n-1)! = 2
     确定第二位:
     k = 2
     index = k / (n-2)! = 1, 说明第15个数的第二位是2
     更新k
     k = k - index*(n-2)! = 0
     确定第三位:
     k = 0
     index = k / (n-3)! = 0, 说明第15个数的第三位是1
     更新k
     k = k - index*(n-3)! = 0
     确定第四位:
     k = 0
     index = k / (n-4)! = 0, 说明第15个数的第四位是4
     最终确定n=4时第15个数为3214
     **/

    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        // 分母的阶乘数
        int[] factorials = new int[n+1];
        //计算n - 1的阶乘
        int fact = 1;
        factorials[0] = 1;   //第一位设置为1 0的阶乘为1
        for (int i = 1; i <= n ; i++) {
            list.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorials[i];
            sb.append(list.remove(index));
            k -= index * factorials[i];
        }
        return sb.toString();

    }

}
