package hard;

/**
 * @author 李聪
 * @date 2020/2/12 9:47
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 *
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 *
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *
 * 说明:
 *
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 */
public class T41_firstMissingPositive {
    public static void main(String[] args) {

    }
    //首次缺失的正数肯定小于等于n+1
    public int firstMissingPositive(int[] nums) {
        //检查1是否存在于数组中
        int n = nums.length;
        int contains = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                contains ++;
                break;
            }
        }
        //如果不存在1
        if(contains == 0)
            return 1;
        //如果长度只有1而且已经存在1
        if(n == 1)
            return 2;
        //程序运行到这里已经不会是1,此时再将其他不可能的数转为1
        for (int i = 0; i < n; i++) {
            if((nums[i] <= 0) || (nums[i] > n)) {
                nums[i] = 1;
            }
        }
        //使用索引和数字符号作为检查器
        //例如，如果nums[1]是负数表示在数组中出现了数字‘1’
        //如果nums[2]是正数，表示数字2没有出现

        //此时数组中已经全部是正数
        //遍历数组。当读到数字 a 时，替换第 a 个元素的符号。
        //注意重复元素：只能改变一次符号。由于没有下标 n ，使用下标 0 的元素保存是否存在数字 n。
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            //如果发现了一个数字a - 改变第a个元素的符号
            if(a == n) {    //用0去表示n
                nums[0] = - Math.abs(nums[0]);
            }else {
                nums[a] = - Math.abs(nums[a]);
            }
        }
       /* 再次遍历数组。返回第一个正数元素的下标。
        如果 nums[0] > 0，则返回 n 。
        如果之前的步骤中没有发现 nums 中有正数元素，则返回n + 1。*/


        //第一个正数的下标，就是第一个缺失的数,从1开始
        for (int i = 1; i < n; i++) {
            if(nums[i] > 0)
                return i;
        }
        if(nums[0] > 0)
            return n;
        return n + 1;
    }
}
