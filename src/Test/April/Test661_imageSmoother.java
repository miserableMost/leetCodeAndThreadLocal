package Test.April;
/**leetCode: 661. 图片平滑器(important)
 *包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *示例 1:输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 */
public class Test661_imageSmoother {
    public static void main(String[] args) {
        int[][] M = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        /*System.out.println(M[0][0]);*/
        int[][] result = imageSmoother(M);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println(",");
        }
    }



    public static int[][] imageSmoother(int[][] M) {
        int hight = M.length;
        int length = M[0].length;
        int[][] newArray = new int[hight][length];
        for (int i = 0; i < hight; i++) {
            for(int j = 0;j < length;j++){
                //先加上自己
                int count = 1;
                int sum = M[i][j];
                //左上 前面一个条件表示左，后面表示上
                if(j-1 >= 0 && i-1 >= 0){
                    sum += M[i-1][j-1];
                    count ++;
                }
                //上
                if(i-1 >= 0){

                    sum += M[i-1][j];

                    count ++;
                }
                //右上
                if(j+1 < length && i-1 >= 0){

                    sum += M[i-1][j+1];
                    count ++;
                }
                //左
                if(j-1 >= 0){
                    sum += M[i][j-1];
                    count ++;
                }
                //右
                if(j+1 < length){
                    sum += M[i][j+1];
                    count ++;
                }
                //左下
                if(j-1 >= 0 && i+1 < hight){
                    sum += M[i+1][j-1];
                    count ++;
                }
                //下
                if(i+1 < hight){
                    sum += M[i+1][j];
                    count ++;
                }
                //右下
                if(j+1 < length && i+1 <hight){
                    sum += M[i+1][j+1];
                    count ++;
                }
                int avg = sum / count;
                newArray[i][j] = avg;


            }
        }
        return newArray;
    }
}
