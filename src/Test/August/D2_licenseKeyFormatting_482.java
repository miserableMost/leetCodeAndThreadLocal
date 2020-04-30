package Test.August;

/**
 * leetCode 482 : 密钥格式化
 * 给定一个密钥字符串S，只包含字母，数字以及 '-'（破折号）。N 个 '-' 将字符串分成了 N+1 组。给定一个数字 K，重新格式化字符串，除了第一个分组以外，每个分组要包含 K 个字符，第一个分组至少要包含 1 个字符。两个分组之间用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 * */
public class D2_licenseKeyFormatting_482 {
    public static void main(String[] args) {

    }

    public String licenseKeyFormatting(String S, int K) {
         StringBuilder sb = new StringBuilder();
         int num = 0;
         for (int i = S.length() - 1; i >= 0 ; i--) {
             //跳过'-'
            if(S.charAt(i) != '-'){
                //长度达到K时
                if(num == K){
                    sb.append("-");
                    num = 0;
                }
                //小写改成大写
                sb.append((char)(S.charAt(i) >= 'a' && S.charAt(i) <= 'z' ? S.charAt(i) - 32 : S.charAt(i)));
                num ++;
            }
         }
         //反转
         return sb.reverse().toString();
    }

}

