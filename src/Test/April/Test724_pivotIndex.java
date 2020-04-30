package Test.April;
/**
 * leetCode:724. 寻找数组的中心索引
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * 示例 1:
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 输入[1,0]结果为0
 */
public class Test724_pivotIndex {
    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,1,1,-1};
        System.out.println(pivotIndex(nums));
    }

   /* 我的做法 ，垃圾的一批
   public static int pivotIndex(int[] nums) {
         int len = nums.length;
         int left = 0;
         int right = 0;
         if(len==0 || len == 1)
             return -1;
         for(int i=1;i<len-1;i++){
             for(int j=0;j<i;j++){
                 left += nums[j];
             }
             for(int j=i+1;j<len;j++){
                 right += nums[j];
             }
             if(left == right){
                 return i;
             }else{
                 left = 0;
                 right = 0;
             }
         }
         return -1;
      }*/
   public static int pivotIndex(int[] nums) {
       int len = nums.length;
       int left = 0;
       int right = 0;
       if(len < 2)
         return -1;
       for(int i=1;i<len;i++){
           right += nums[i];
           //在这里判断
       }
       if(right == left)
           return 0;
       /*for(int i=0;i<len-1;i++){
           if(left == right)
               //经历循环加1后这个i为中心索引
               return i;
           //此时的i为中心索引的前一个元素
           left += nums[i];
           right -= nums[i+1];
       }
       if(left == right)
           return len-1;
       return -1;*/
       for(int i=0;i<len-1;i++){

           left += nums[i];
           right -= nums[i+1];
           if(left == right)
               return i+1;
       }
       if(left == right)
           return len-1;
       return -1;

   }
}
