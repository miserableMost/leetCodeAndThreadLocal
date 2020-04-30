package hard;

/** leetcode42 求雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */
public class T42_trap_10_6 {
    public static void main(String[] args) {

    }
    //找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        //求出左边最大的--从右开始
        for (int i = 1; i < n - 1; i++) {
            //动态
            max_left[i] = Math.max(max_left[i - 1],height[i - 1]);
            max_right[n - 1 - i] = Math.max(max_right[n - i],height[n - i]);
        }
        //求出右边最大的
       /* for (int i = n - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1],height[i + 1]);
        }*/
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(max_left[i],max_right[i]);
            if(min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}
