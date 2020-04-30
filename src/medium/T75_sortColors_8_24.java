package medium;

/**
 * leetCode 75:颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class T75_sortColors_8_24 {
    public static void main(String[] args) {
        int[] nums = {0,2,1};
        sortColors(nums);
    }
    public static void sortColors(int[] nums) {
        if(nums.length <= 1)
            return;
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end;i++) {
            if(nums[i] == 0){
                //交换到最前--左边已经扫描过
                swap(nums,i,start);
                start ++;

            }else if(nums[i] == 2){
                //交换到最后，此时此处元素仍需要判断
                swap(nums,i,end);
                end --;
                i --;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
