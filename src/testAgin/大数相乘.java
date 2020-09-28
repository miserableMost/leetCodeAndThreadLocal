package testAgin;

/**
 * @author 李聪
 * @date 2020/9/16 20:26
 */
public class 大数相乘 {
    public static void main(String[] args) {
        System.out.println(111111 * 999);
        大数相乘 big = new 大数相乘();
        System.out.println(big.bigMulti("111111", "999"));
    }
    public String bigMulti(String a,String b) {
        int[] res = new int[a.length() + b.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            int x = a.charAt(i) - '0';
            for(int j = b.length() - 1;j >= 0;j --){
                int y = b.charAt(j) - '0';
                res[i + j] += (res[i + j + 1] + x * y) /10;
                res[i + j + 1] = (res[i + j + 1] + x * y)%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if(i == 0 && res[i] == 0)
                continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
