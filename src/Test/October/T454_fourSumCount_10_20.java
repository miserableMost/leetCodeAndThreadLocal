package Test.October;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 454.四数相加
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */
public class T454_fourSumCount_10_20 {
    public static void main(String[] args) {

    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int N = A.length;
        //先用hashmap记录C、D之和
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map.put(C[i] + D[j],map.getOrDefault(C[i] + D[j],0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = -(A[i] + B[j]);
                if(map.containsKey(cur)) {
                    ans += map.get(cur);
                }
            }
        }
        return ans;
    }




}
