package medium;

/**
 * @author 李聪
 * @date 2020/9/16 18:12
 * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 *
 * 示例 1:
 *
 * 输入: a = 2, b = [3]
 * 输出: 8
 *
 * 示例 2:
 *
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 *
 */
public class T372_超级次方 {
    int mod = 1337;
    public static void main(String[] args) {

    }
    public int superPow(int a,int[] b){
        int len = b.length;
        return indexPow(a,b,len);
    }

    private int indexPow(int a, int[] b, int idx) {
        if(idx < 1){
            return 1;
        }
        int part1 = quickPow(a,b[idx - 1]);
        idx --;
        int part2 = quickPow(indexPow(a,b,idx),10);
        return part1 * part2 % mod;
    }

    private int quickPow(int n, int m) {
        n %= mod;
        int res = 1;
        int base = n;
        while(m != 0){
            if((m & 1) == 1){
                res = res * base % mod;
            }
            base = base * base % mod;
            m = m >> 1;
        }
        return res % mod;
    }
}
