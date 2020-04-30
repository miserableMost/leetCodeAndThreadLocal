package zuoshensuanfa;

/**
 * @author 李聪
 * @date 2019/12/8 15:21
 */
//动态规划类似于杨辉三角
public class Easy {
    /**
     *
     * @param N 一共有1-N的位置
     * @param M 可以来到的位置
     * @param P 可以走的步数
     * @param K 最终停在的位置
     * @return
     */
    public static int ways(int N,int M,int P,int K) {
        if(N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
            return 0;
        }
        if(P == 0) {
            return M == K ? 1 : 0;
        }
        int res = 0;
        if(M == 1) {
            res = ways(N,M + 1,P - 1,K);
        }else if(M == N) {
            res = ways(N,M - 1,P - 1,K);
        }else {

            res = ways(N,M+1,P - 1,K) + ways(N,M - 1,P - 1,K);
        }
        return res;
    }


}
