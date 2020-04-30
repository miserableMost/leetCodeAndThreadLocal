package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author 李聪
 * @date 2020/4/11 17:51
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 示例 1:
 *
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 *
 */
public class T253_会议室 {
    public static void main(String[] args) {
        int[][] nums = {{9,10},{4,9},{4,17}};
        int i = minMeetingRooms(nums);
        System.out.println(i);
    }
    public static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //建一个最小堆,保证最早结束的会议时间
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if(queue.peek() <= intervals[i][0]) {
                //腾出一个房间
                queue.poll();
            }
            //将新的加入这个房间
            queue.add(intervals[i][1]);
        }
        return queue.size();

    }
}
