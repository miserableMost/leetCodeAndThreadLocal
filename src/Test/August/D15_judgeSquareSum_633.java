package Test.August;

/**
 * leetCode 633 : 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 */
public class D15_judgeSquareSum_633 {
    public static void main(String[] args) {
        boolean b = judgeSquareSum(3);
        System.out.println(b);
    }
    public static boolean judgeSquareSum(int c) {
        /*for (int i = 0; i <= Math.sqrt(c); i++) {
            int p = c - i * i;
            for (int j = 0; j <= Math.sqrt(c); j++) {
                if(p == j * j)
                    return true;
            }
        }
        return false;*/
        //双指针
        int i = 0,j = (int) Math.sqrt(c);
        while(i <= j){
            int num = i * i + j * j;
            if(num == c)
                return true;
            //和太小的话将小指针后移
            else if(num < c)
                i ++;
            else
                j --;
        }
        return false;
    }
}
