package huawei;

/**
 * @author 李聪
 * @date 2020/9/20 13:49
 */
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{2,4,6},{3,9,5}};
        System.out.println(getMax(nums));
    }
    public static int getMax(int[][] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int m = nums.length;
        int n = nums[0].length;
        for(int i = 1;i < m;i ++){
            nums[i][0] += nums[i - 1][0];
        }
        for(int j = 1;j < n;j ++){
            nums[0][j] += nums[0][j - 1];
        }
        for(int i = 1;i < m;i ++){
            for(int j = 1;j < n;j ++){
                nums[i][j] += Math.max(nums[i - 1][j],nums[i][j - 1]);
            }
        }
        return nums[m - 1][n - 1];
    }
}
