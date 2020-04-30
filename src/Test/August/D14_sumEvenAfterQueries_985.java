package Test.August;

import java.util.Arrays;

/**
 * leetCode 985 : 查询后的偶数和
 *  给出一个整数数组 A 和一个查询数组 queries。
 *
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 */
public class D14_sumEvenAfterQueries_985 {
    public static void main(String[] args) {
        int[][] que = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] a = {1,2,3,4};
        int[] ints = sumEvenAfterQueries(a, que);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[queries.length];
        int count = 0;
        for (int j = 0; j < A.length; j++) {
            if(A[j] % 2 == 0){
                count += A[j];
            }
        }
        for (int i = 0; i < queries.length; i++) {

            //原来是偶数被变为奇数
            if(A[queries[i][1]] % 2 == 0 && queries[i][0] % 2 != 0){
                count -= A[queries[i][1]];
            //原来是奇数被变成了偶数
            }else if(A[queries[i][1]] % 2 != 0 && queries[i][0] % 2 != 0){
                count += A[queries[i][1]] + queries[i][0];
            //原来是偶数现在还是偶数
            }else if(A[queries[i][1]] % 2 == 0 && queries[i][0] % 2 == 0){
                count += queries[i][0];
            }//奇数还是奇数则对结果无影响
            A[queries[i][1]] += queries[i][0];
            res[i] = count;
        }
        return res;
    }
}
