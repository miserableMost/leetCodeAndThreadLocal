package medium2;

/**
 * leetCode 456 : 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 */
public class T456_find132pattern {
    public static void main(String[] args) {
        int[] nums = {2,3,4,1,5};
        boolean pattern = find132pattern(nums);
        System.out.println(pattern);
    }
    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int leftMin = nums[0];
        int right = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            // 獲取當中的數字
            int num2 = nums[i];
            // 左邊始終獲取最小值
            if (leftMin > nums[i-1]) leftMin = nums[i-1];
            if (leftMin > num2) continue;
            // 右邊遍歷，得到符合條件的就返回true
            for (int j = i + 1; j < nums.length; j++) {
                right = nums[j];
                if (right < num2 && right > leftMin) return true;
            }
        }
        return false;
    }

}
