package Test.July;

/**
 * leetCode 704:二分查找
 */
public class Test704_search {
    public static void main(String[] args) {
         int[] nums = {-1,0,3,5,9,12};
         int target = 2;
         System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
       // return BinarySearch(nums,0,nums.length - 1,target);
        //定义返回结果
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                //向右
                left = mid + 1;
            }else if(nums[mid] > target){
                //向左
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] nums,int left,int right,int target){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(nums[mid] < target){
            return BinarySearch(nums,mid + 1,right,target);  //向右递归
        }else if(nums[mid] > target){
            return BinarySearch(nums,left,mid-1,target);
        }else{
            return mid;
        }

    }
}
