package tryTest;

import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/7/28 22:51
 */
public class 猿辅导2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        //int N = sc.nextInt();
        String str = sc.nextLine();
        int len = str.length();
        //上下半部分的高度
        int s = (len - 1)/3;
        int space = 2 * s - 1;
        int hight = space + 2;

        //计算当前数字
        int i = 0;
        //计算层数
        int k = 0;
        while(i < str.length()) {
            if(k < hight / 2) {
                //输出开头的空格
                for (int j = 0; j < k; j++) {
                    System.out.print(" ");
                }
                char first = str.charAt(i);
                i ++;
                char second = str.charAt(i);
                i ++;
                System.out.print(first);
                //输出中间space个0;
                for (int j = 0; j < space; j++) {
                    System.out.print(" ");
                }
                System.out.print(second);
                System.out.println();
                k ++;
                space -= 2;
            }else {
                for (int j = 0; j < hight / 2; j++) {
                    System.out.print(" ");
                }
                char single = str.charAt(i);
                System.out.print(single);
                i ++;
                k ++;
                System.out.println();
            }
        }

    }
}
