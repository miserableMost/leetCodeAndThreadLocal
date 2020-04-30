package Test.July;

/**
 * leetCode 944:删列造序
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 *
 * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，
 * 形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
 *
 * 比如，有 A = ["abcdef", "uvwxyz"]，

 */
public class Test944_minDeletionSize_7_24 {

    public static void main(String[] args) {
         String[] a = {"zyx", "wvu", "tsr"};
         System.out.println(minDeletionSize(a));

    }
    public static int minDeletionSize(String[] A) {
        int count = 0;
        for (int j = 0; j < A[0].length(); j++) {
            for (int i = 1; i < A.length; i++) {
                //检查同一列此行的数是否比上行的数小
                if(A[i].charAt(j) < A[i - 1].charAt(j)){
                    count ++;
                    break;
                }
            }
        }

        /*char [][] res = new char[A.length][A[0].length()];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = A[i].charAt(j);
            }
        }
        //一列一列的遍历
        int count = 0;
        for (int j = 0; j < A[0].length(); j++) {
            for (int i = 1; i < A.length; i++) {
                //检查同一列此行的数是否比上行的数小
                if(res[i][j] < res[i - 1][j]){
                    count ++;
                    break;
                }
            }
        }*/
        /*for (char[] re : res) {
            for (char c : re) {
                System.out.print(c+" ");
            }
            System.out.println();
        }*/
        return count;
    }
}
