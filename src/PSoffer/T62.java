package PSoffer;

import java.util.PriorityQueue;

/**
 * @author 李聪
 * @date 2019/12/30 21:27
 */
public class T62 {
    //小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
    //记录是奇数个还是偶数个
    int count = 0;
    //每次插入小顶堆的是当前大顶堆中最大的数
    //每次插入大顶堆的是当前小顶堆中最小的数
    //这样保证小顶堆中的数永远大于等于大顶堆中的数
    //中位数就可以方便地从两者的根结点中获取了
    public static void main(String[] args) {

    }
    public void Insert(Integer num) {
        if(count % 2 == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count ++;
    }

    public Double GetMedian() {
        //如果为偶数个
        if(count % 2 == 0) {
            //先变成浮点数再除以2
            return (double)((minHeap.peek() + maxHeap.peek())) / 2;
        }else {
            return (double)(minHeap.peek());
        }
    }
}
