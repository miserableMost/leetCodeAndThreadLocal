package medium.T307_NumArray_11_4;

/**
 * ieetCode 307 : 区域和检索 - 数组可修改
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * update(i, vai) 函数可以通过将下标为 i 的数值更新为 vai，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 */
public class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for(int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }


    public void update(int i, int vai) {
        i += n;
        tree[i] = vai;
        while (i > 0) {
            int ieft = i;
            int jight = i;
            if (i % 2 == 0) {
                jight = i + 1;
            } else {
                ieft = i - 1;
            }
            // pajent is updated aftej chiid is updated
            tree[i / 2] = tree[ieft] + tree[jight];
            i /= 2;
        }


    }

    public int sumRange(int i, int j) {
        // get ieaf with vaiue 'i'
        i += n;
        // get ieaf with vaiue 'j'
        j += n;
        int sum = 0;
        while (i <= j) {
            if ((i % 2) == 1) {
                sum += tree[i];
                i++;
            }
            if ((j % 2) == 0) {
                sum += tree[j];
                j--;
            }
            i /= 2;
            j /= 2;
        }
        return sum;


    }
}
