package tryTest;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/7/25 17:19
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();

            int[] dp = new int[n];
            for (int j = 0; j < n; j++) {
                dp[j] = sc.nextInt();
            }

            //用优先队列
            PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b - a);
            for (int num : dp) {
                if(num > 0){
                    queue.offer(num);
                }
            }
            int first = 0,second = 0,third = 0,sum = 0;
            while(queue.size() > 2) {
                first = queue.poll();
                second = queue.poll();
                third = queue.poll();
                if(--first > 0){
                    queue.offer(first);
                }
                if(--second > 0){
                    queue.offer(second);
                }
                if(--third > 0) {
                    queue.offer(third);
                }
                sum ++;
            }
            ans.add(sum);


        }
        for (int i = 0; i < c; i++) {
            System.out.println(ans.get(i));
        }
    }
}
