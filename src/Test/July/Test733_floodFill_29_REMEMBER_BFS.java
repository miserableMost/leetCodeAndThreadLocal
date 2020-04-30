package Test.July;

/**
 * leetCode 733:图像渲染
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * 最后返回经过上色渲染后的图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * DFS），说得简单一点，这就叫四叉树遍历框架。坐标 (x, y) 就是 root，四个方向就是 root 的四个子节点。
 *
 * int[][] floodFill(int[][] image,
 *         int sr, int sc, int newColor) {
 *
 *     int origColor = image[sr][sc];
 *     fill(image, sr, sc, origColor, newColor);
 *     return image;
 * }
 *
 * void fill(int[][] image, int x, int y,
 *         int origColor, int newColor) {
 *     // 出界：超出边界索引
 *     if (!inArea(image, x, y)) return;
 *     // 碰壁：遇到其他颜色，超出 origColor 区域
 *     if (image[x][y] != origColor) return;
 *     image[x][y] = newColor;
 *
 *     fill(image, x, y + 1, origColor, newColor);
 *     fill(image, x, y - 1, origColor, newColor);
 *     fill(image, x - 1, y, origColor, newColor);
 *     fill(image, x + 1, y, origColor, newColor);
 * }
 *
 * boolean inArea(int[][] image, int x, int y) {
 *     return x >= 0 && x < image.length
 *         && y >= 0 && y < image[0].length;
 * }

 */
public class Test733_floodFill_29_REMEMBER_BFS {

    public static void main(String[] args) {

    }
   /* public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origColor = image[sr][sc];
        fill(image,sr,sc,origColor,newColor);
        return image;
    }
    public void fill(int[][] image,int x,int y,int origColor,int newColor){
        //不在界内
        if(! inArea(image,x,y))
            return;
        //与初始颜色不同
        if(image[x][y] != origColor)
            return;
        //已经探索过
        if(image[x][y] == -1)
            return;
        image[x][y] = -1;
        fill(image,x,y - 1,origColor,newColor);
        fill(image,x,y + 1,origColor,newColor);
        fill(image,x - 1,y,origColor,newColor);
        fill(image,x + 1,y,origColor,newColor);
        image[x][y] = newColor;

    }
    //定义一个方法判断是否在界内
    public boolean inArea(int[][] image,int x,int y){
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }*/
    Integer value = null;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        //如果颜色不同
        if(image[sr][sc] != newColor){
            //赋值一波初值
            if(value == null)
                value = image[sr][sc];
            //新位置颜色是否与原来的相同
            if(image[sr][sc] != value)
                return image;
            //着色
            image[sr][sc] = newColor;
            //向上
            if(sr > 0)
                floodFill(image,sr - 1,sc,newColor);
            //向下
            if(sr < image.length - 1)
                floodFill(image,sr + 1,sc,newColor);
             //向左
            if(sc > 0)
                floodFill(image,sr,sc - 1,newColor);
            //向右
            if(sc < image[0].length - 1)
                floodFill(image,sr,sc + 1,newColor);
        }
        return image;

    }

}
