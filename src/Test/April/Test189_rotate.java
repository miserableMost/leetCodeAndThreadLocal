package Test.April;
/**leetCode 189:旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class Test189_rotate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
    }
    //大佬写的
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        //先把整个数组反过来，因为后面的一定会到前面去
        reverse(nums, 0, n - 1);
        //移几步前面就剩下几个
        reverse(nums, 0, k - 1);
        //将后面的反转，顺带将不该排在前面的老哥反过来
        reverse(nums, k, n - 1);
}

    //反转程序
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    //我写的
    /*public static void rotate(int[] nums, int k) {
        int n = 0;
        if(k>=nums.length)
            k = k%nums.length;
        if(k==0)
             return;
        //算出新的数组从原来的哪个开始
        int i = nums.length-k;
        int[] rotateNums = new int[nums.length];
        //将原来开始转折的到最后
        for(int j=i;j<nums.length;j++){
            rotateNums[n] = nums[j];
            n++;
        }
        //从0到最开始转折
        for(int j=0;j<i;j++){

            rotateNums[n] = nums[j];
            n++;
        }

        for(int m=0;m<nums.length;m++){
            nums[m]=rotateNums[m];
            System.out.println(nums[m]);
        }

*/


}
