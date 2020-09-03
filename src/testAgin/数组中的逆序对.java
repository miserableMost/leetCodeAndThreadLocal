package testAgin;

/**
 * @author 李聪
 * @date 2020/6/25 11:34
 */
public class 数组中的逆序对 {
    public static void main(String[] args) {
       /* int[] nums = {1,2,3};
        int[] clone = nums.clone();
        nums[0] = 12;
        System.out.println(clone[0]);*/
    }
    public int reversePair(int[] nums) {
        int len = nums.length;
        if(len < 2)
            return 0;
        int[] copy = nums.clone();
        //创建一个临时数组
        int[] temp = new int[len];
        return reversePairs(copy,0,len - 1,temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if(left == right)
            return 0;
        int mid= left + (right - left) / 2;
        int leftPairs = reversePairs(nums,left,mid,temp);
        int rightPairs = reversePairs(nums,mid + 1,right,temp);
        if(nums[mid] <= nums[mid + 1])
            return leftPairs + rightPairs;
        int crossPairs = mergeAndCount(nums,left,mid,right,temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            //当左指针搞完了
            if(i == mid + 1) {
                nums[k] = temp[j];
                j ++;
            //当右边的搞完了
            }else if(j == right + 1) {
                nums[k] = temp[i];
                i ++;
                /*注意一定是<=,否则排序不稳定*/
            }else if(temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i ++;
            }else {
                nums[k] = temp[j];
                j ++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
