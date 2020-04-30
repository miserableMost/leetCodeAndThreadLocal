package hard;

import java.util.Arrays;

/** leetCode85 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class T85_maximalRectangle_10_7 {
    public static void main(String[] args) {

    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right,n);

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            int cur_left = 0,cur_right = n;
            //更新高
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    height[j] ++;
                else
                    height[j] = 0;
            }
            //更新左
            for (int j = 0; j < n; j++) {
                //当前行之上的全部0已经考虑在当前版本的left中，
                if(matrix[i][j] == '1')
                    left[j] = Math.max(left[j],cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            //更新右
            for (int j = n - 1; j >= 0 ; j--) {
                if(matrix[i][j] == '1')
                    right[j] = Math.min(right[j],cur_right);
                 else {
                     right[j] = n;
                     cur_right = j;
                }
            }
            //更新面积
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea,(right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;







       /*if(matrix.length == 0)
           return 0;
       int max = 0;
       int[] dp = new int[matrix.length];
        for (int j = 0; j < matrix[0].length; j++) {
            //每一列如果有给每一行加加
            for (int i = 0; i < matrix.length; i++) {
                if(matrix[i][j] == '1')
                    dp[i] = dp[i] + 1;
                else
                    dp[i] = 0;
            }
            max = Math.max(max,largestRectanglearea(dp));
        }
        return max;
    }
    public int largestRectanglearea(int[] heights) {
      *//*   int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MaX_VaLUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(heights[j],minHeight);
                maxarea = Math.max(maxarea,minHeight * (j - i + 1));
            }
        }
        return maxarea;*//*
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
        return maxarea;*/
    }
}
