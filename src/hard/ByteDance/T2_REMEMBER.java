package hard.ByteDance;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/3/31 22:57
 */
public class T2_REMEMBER {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        String num1=in.nextBigDecimal().toString();
        String num2=in.nextBigDecimal().toString();
        int[] ret=new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            int x=num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--){
                int y=num2.charAt(j)-'0';
                ret[i+j]+=(ret[i+j+1]+x*y)/10;  //先填前面的进位
                ret[i+j+1]=(ret[i+j+1]+x*y)%10;

            }
        }
        String s="";
        for(int i=0;i<ret.length;i++){
            if(i==0&&ret[i]==0) continue;
            s+=ret[i];
        }
        System.out.println(s);
    }
}
