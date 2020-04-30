package sort;

/**
 * @author 李聪
 * @date 2020/4/23 17:31
 */
public class TestQucik {
    public static void main(String[] args) {

    }
    public static void quick(int[] nums) {
        quickSort(nums,0,nums.length - 1);
    }
    public static void quickSort(int[] nums,int left,int right) {
        if(left > right) {
            return;
        }
        //设置基准值
        int pirot = nums[left];
        int l = left,r = right;
        while(l < r) {
            while(l < r && nums[r] >= pirot) {
                r --;
            }
            while(l < r && nums[l] <= pirot) {
                l ++;
            }
            if(l < r) {
                swap(nums,l,r);
            }
        }

    }
    private static void swap(int[] nums,int left,int right) {
        nums[left] = nums[left] + nums[right] - (nums[right] = nums[left]);
    }
}
