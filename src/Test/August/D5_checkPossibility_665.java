package Test.August;

/**
 * leetCode 665:非递减数列
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 *
 */
public class D5_checkPossibility_665 {
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{3,4,2,3}));
    }

    public static boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
          if(nums[i - 1] > nums[i]){
              if(count > 0){
                  return false;
              }else {
                  if((i-2>=0)&&nums[i]<nums[i-2]){
                      nums[i]=nums[i-1];
                  }
                  count ++;
              }

          }
        }
        return true;
    }
}
