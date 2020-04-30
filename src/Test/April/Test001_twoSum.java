package Test.April;

import java.util.Arrays;

public class Test001_twoSum {
    public static void main(String[] args) {
        Test001_twoSum a = new Test001_twoSum();
        int[] nums = {2,7,11,15};
        int target = 13;
        int[] x = a.twoSum(nums,target);
        System.out.println(Arrays.toString(x));
    }

    public int[] twoSum(int[] nums, int target) {
        int [] m  = new int[2];
        Loop:for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(target == nums[i]+nums[j]) {
                    return new int[] {i,j};

                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
