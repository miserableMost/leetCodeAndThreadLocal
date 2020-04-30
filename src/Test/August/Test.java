package Test.August;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int[] nums = {4,5,2,8};
        KthLargest k = new KthLargest(3,nums);
        int res = k.add(3);
        System.out.println(res);

    }
}

class KthLargest {

    final PriorityQueue<Integer> minHeap;

    final int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.minHeap = new PriorityQueue(k);

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }
    //维持小顶堆相当于保持一个K长度的数组，最大的再最后，第k大的就必然在第一个
    public int add(int val) {

        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (minHeap.peek() < val){
            //出队
            minHeap.poll();
            //进队
            minHeap.offer(val);
        }

        return minHeap.peek();

    }


}