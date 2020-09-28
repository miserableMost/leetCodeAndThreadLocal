package sougou;

import java.util.Arrays;

/**
 * @author 李聪
 * @date 2020/9/5 18:00
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.numberofprize(9, 3, 3));

    }
    public int numberofprize (int a, int b, int c) {
        // write code here
        if(a == b && b == c)
            return a;
        int[] ans = new int[3];
        ans[0] = a;
        ans[1] = b;
        ans[2] = c;
        Arrays.sort(ans);
        int A = ans[0],B = ans[1],C = ans[2];
        if(A == B) {
            return getTwoSame(A,B,C);
        }else {
            B --;
            C --;
            while(B >= A + 1){
                A ++;
                B --;
                C --;
            }
            B ++;
            C ++;
            if(A == B) {
                return getTwoSame(A,B,C);
            }else if(A < B) {
                while(A < B && C - 2 >= A) {
                    C -= 2;
                    A ++;
                }
                if(A == B){
                    return getTwoSame(A,B,C);
                }
            }
            return A;
        }

    }
    public int getTwoSame(int A,int B,int C){
        C -= 4;
        while(C >= A + 1) {
            A ++;
            B ++;
            C -= 4;
        }
        return A;
    }
}
