package medium2;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 */
public class T275_hIndex_9_26 {
    public static void main(String[] args) {
        int[] nums = {0,1,3,5,6};
        T275_hIndex_9_26 test = new T275_hIndex_9_26();
        int i = test.hIndex(nums);
        System.out.println(i);
    }
    //某个索引 i 到 citations 的末尾索引的长度，即区间 [i, len - 1] 的长度，即 len - 1 - i + 1 = len - i。
    public int hIndex(int[] citations) {
         int left = 0;
         int right = citations.length;
         while(left < right) {
             int mid = left + (right - left) / 2;
             int assume = citations[mid];
             int actul = citations.length - mid;
             if (assume < actul) {
                 left = mid + 1;
             }else {
                 right = mid;
             }
         }
         return citations.length - left;
    }
}
