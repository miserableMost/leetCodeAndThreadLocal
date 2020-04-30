package medium;

import java.util.TreeSet;

/**
 * leetCode 220 : 存在重复元素
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
 * 并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 */
public class T220_containsNearbyAlmostDuplicate_8_24 {
    public static void main(String[] args) {

    }
    //下面给出整个算法的伪代码：
    //
    //    初始化一颗空的二叉搜索树 set
    //    对于每个元素xxx，遍历整个数组
    //        在 set 上查找大于等于xxx的最小的数，如果s−x≤ts - x \leq ts−x≤t则返回 true
    //        在 set 上查找小于等于xxx的最大的数，如果x−g≤tx - g \leq tx−g≤t则返回 true
    //        在 set 中插入xxx
    //        如果树的大小超过了kkk, 则移除最早加入树的那个数。
    //    返回 false
    //
    //我们把大于等于 xxx 的最小的数 sss 当做 xxx 在 BST 中的后继节点。同样的，我们能把小于等于 xxx 最大的数 ggg 当做 xxx 在 BST 中的前继节点。sss 和 ggg 这两个数是距离 xxx 最近的数。因此只需要检查它们和 xxx 的距离就能知道条件二是否满足了。

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer s = set.ceiling(nums[i]);
            if(s != null && s <= t + nums[i])
                return true;
            Integer f = set.floor(nums[i]);
            if(f != null && nums[i] <= f + t)
                return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
