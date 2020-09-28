package bilibili;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/9/4 18:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
    }
    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int start = 0;
        int end = 0;
        int maxNum = 0;
        int zero = 0;
        while(end != arr.length){
            if(arr[end] == 0) {
                end ++;
                zero ++;
            }
            while(zero > k) {
                if(arr[start] == 0){
                    start ++;
                    --zero;
                }
            }
            int num = end - start;
            maxNum = Math.max(maxNum,num);
        }
        return maxNum;
    }
}
