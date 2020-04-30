package game;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();


    }
    public int divide(int[] a,int[] b){
        int i = 0;
        while(i < a.length)
           if(a[i] == 0 || b[i] == 0)
               i++;
            else if(a[i] == 0)
                return 0;
            else if(b[i] == 0)
                return (1 / 0);
            else
                return a[i] / b[i];
        return 0;

    }
}
