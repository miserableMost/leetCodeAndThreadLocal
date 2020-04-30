package Test.August;

/**
 * leetCode 812: 最大三角形面积
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 *
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。

 */
public class D1_largestTriangleArea_812 {
    public static void main(String[] args) {

    }
    public double largestTriangleArea(int[][] points) {
        //最大三角形面积
        double maxArea = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    //海伦公式
                    double a = Math.sqrt(Math.pow(points[i][0] - points[j][0],2) + Math.pow(points[i][1] - points[j][1],2));
                    double b = Math.sqrt(Math.pow(points[j][0] - points[k][0],2) + Math.pow(points[j][1] - points[k][1],2));
                    double c = Math.sqrt(Math.pow(points[k][0] - points[i][0],2) + Math.pow(points[k][1] - points[i][1],2));
                    // 如果3个点在一条线上，面积为空，直接忽略
                    if(a + b == c || a + c == b || b + c == a){
                        continue;
                    }

                    double p = (a + b + c) / 2;
                    double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    // 如果面积不是一个数字，跳过循环
                    if (Double.isNaN(s)) {
                        continue;
                    }
                    maxArea = Math.max(s,maxArea);
                }
            }
        }
        return maxArea;
    }
}
