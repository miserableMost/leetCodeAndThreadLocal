package hard.ByteDance;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/5 21:31
 */
public class T17 {

    public static class  Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Node> queue = new PriorityQueue<>((n1,n2) -> n2.x - n1.x);  //按y大顶堆排序
        for (int i = 0; i < N ; i++) {
           Node node = new Node(sc.nextInt(),sc.nextInt());
           queue.add(node);
        }
        findNode(queue);

    }

    private static void findNode(PriorityQueue<Node> queue) {
        ArrayList<Node> list = new ArrayList<>();
        //y最大的肯定是
        Node node = queue.poll();
        list.add(node);
        int maxY = node.y;
        while(!queue.isEmpty()) {
             Node cur = queue.poll();
             if(cur.y > maxY) {
                 maxY = cur.y;
                 list.add(cur);
             }
        }
        int s = list.size();
        for (int i = list.size() - 1; i >= 0 ; i--) {
            System.out.println(list.get(i).x + " " + list.get(i).y);
        }

    }


}
