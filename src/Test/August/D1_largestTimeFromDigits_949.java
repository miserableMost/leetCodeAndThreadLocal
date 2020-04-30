package Test.August;

/**
 * leetCode 949 :给定数组能组成的最大时间
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 *
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 *
 */
public class D1_largestTimeFromDigits_949 {
    public static void main(String[] args) {
        D1_largestTimeFromDigits_949 d1= new D1_largestTimeFromDigits_949();
        int[] a = {0,0,4,0};
        String s = d1.largestTimeFromDigits(a);
        System.out.println(s);
    }
    public  String largestTimeFromDigits(int[] A) {
        int ans = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(i != j){
                    for (int k = 0; k < 4; k++) {
                        if(k != i && k != j){
                            int l = 6 - i - j - k;     //0+1+2+3 = 6
                            int hours = 10 * A[i]+ A[j];
                            int mins = 10 * A[k] + A[l];
                            if(hours < 24 && mins < 60)
                                ans = Math.max(ans,hours * 60 + mins);
                         }
                    }

                }
            }
        }
        return ans >= 0 ? String.format("%02d:%02d", ans / 60, ans % 60) : "";

    }
}
