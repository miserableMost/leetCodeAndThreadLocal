package medium;

/**leetCode 11 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai)
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *

 */
public class T11_maxArea_10_25 {
    public static void main(String[] args) {

    }
    //矮指针代表着面积的高度已经固定了，那么想增大面积只有靠增加宽度，但是宽度已经不能增加了 所以可以舍弃这个矮指针了
    public int maxArea(int[] height) {
        //定义两个指针
        int left = 0;
        int right = height.length - 1;
        //定义最大容器变量
        int maxArea = 0;
        while(left < right) {
            maxArea = Math.max(maxArea,Math.min(height[right],height[left]) * (right - left));
            if(height[left] < height[right]) {
                //如果左边的较小--左边往右移
                left ++;
            }else {
                right --;
            }
        }
        return maxArea;
    }
}
