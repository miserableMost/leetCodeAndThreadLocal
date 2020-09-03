package E360;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/8/22 17:01
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }
        for (int i = 0; i < m; i++) {
            if(arr[i] == 1) {
                int tmp = queue.pollFirst();
                queue.addLast(tmp);
            }else if(arr[i] == 2){
                swap(queue);
            }
        }
        for (int i = 0; i < queue.size(); i++) {
            if(i != queue.size() - 1) {
                System.out.print(queue.get(i) + " ");
            }else {
                System.out.println(queue.get(i));
            }
        }
    }

    private static void swap(LinkedList<Integer> queue) {
        int size = queue.size();
        size = (size / 2) * 2;
        if(size <= 1)
            return;
        for (int i = 0; i + 1 < size; i += 2) {
            int tmp1 =  queue.get(i);
            int tmp2 = queue.get(i + 1);
            queue.remove(i);
            queue.remove(i);
            queue.add(i,tmp2);
            queue.add(i + 1,tmp1);
        }
    }
}
