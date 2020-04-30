package Test.July;

import java.util.HashSet;
import java.util.Set;

/**
 * leetCode 202: 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，
 * 每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *

 */
public class Test202_isHappy_30 {
    static boolean flag = false;
    public static void main(String[] args) {
        boolean happy = isHappy(1111111);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
       doHappy(n);
       return flag;
    }

    public static void doHappy(int n){
        Set<Integer> res = new HashSet<>();
        int sum = 0;
        String sn = Integer.toString(n);
        for (int i = 0; i < sn.length(); i++) {
            sum += Math.pow(Integer.valueOf(sn.charAt(i)+""),2);

        }
        if(sum == 1){
            flag = true;
            return;
        //如果sum已经出现了，则会进入无限循环
        }else if(res.contains(sum)){
            return;
        }
        res.add(sum);
        isHappy(sum);

    }
}
