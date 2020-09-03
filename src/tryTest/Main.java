package tryTest;

/**
 * @author 李聪
 * @date 2020/7/25 17:07
 */
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for(int i = 0;i < n;i ++) {
            if(map.get(arr[i]) > m) {
                continue;
            }
            if(i == n - 1) {
                System.out.print(arr[i] );
            }else {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
