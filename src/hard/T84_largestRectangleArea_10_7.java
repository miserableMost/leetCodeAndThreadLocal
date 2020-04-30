package hard;

import java.util.Stack;

/** leetCode 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class T84_largestRectangleArea_10_7 {
    public static void main(String[] args) {

    }
    public int largestRectanglearea(int[] heights) {
      /*   int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MaX_VaLUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(heights[j],minHeight);
                maxarea = Math.max(maxarea,minHeight * (j - i + 1));
            }
        }
        return maxarea;*/
        //将索引存入栈
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  //为了方便处理第一个元素
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                //本身就是当前i的前一个操作，故i-1,i-1-top + 1表示长度，但stack.peek为top-1
                maxarea = Math.max(maxarea,heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            maxarea = Math.max(maxarea,heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }
}
