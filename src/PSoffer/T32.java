package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/25 19:45
 */
public class T32 {
    public static void main(String[] args) {

    }
    //三指针
    public int GetUglyNumber_Solution(int index) {
        if(index == 0)
            throw new RuntimeException("不符合常理");
        int[] dp = new int[index];
        dp[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0;
        for (int i = 1; i < index; i++) {
            int min = Math.min(dp[i2] * 2,Math.min(dp[i3] * 3,dp[i5] * 5));
            if(min == dp[i2] * 2) i2 ++;
            if(min == dp[i3] * 3) i3 ++;
            if(min == dp[i5] * 5) i5 ++;
            dp[i] = min;
        }
        return dp[index - 1];
    }
}
