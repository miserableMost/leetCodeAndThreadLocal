package Test.October;

/**
 * leetCode 378 :有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 *
 * 示例:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13
 *
 */
public class T378_kthSmallest_10_20 {
    public static void main(String[] args) {
        int[][] m = {{1,5,9},{10,11,13},{12,13,15}};
        int i = kthSmallest(m, 8);
        System.out.println(i);
    }

    /**
     * 1.找出二维矩阵中最小的数left，最大的数right，那么第k小的数必定在left~right之间
     * 2.mid=(left+right) / 2；在二维矩阵中寻找小于等于mid的元素个数count
     * 3.若这个count小于k，表明第k小的数在右半部分且不包含mid，即left=mid+1, right=right，又保证了第k小的数在left~right之间
     * 4.若这个count大于k，表明第k小的数在左半部分且可能包含mid，即left=left, right=mid，又保证了第k小的数在left~right之间
     * 5.因为每次循环中都保证了第k小的数在left~right之间，当left==right时，第k小的数即被找出，等于right
     *
     * 注意：这里的left mid right是数值，不是索引位置。
     *
     * @param matrix
     * @param k
     * @return
     */
    public static int kthSmallest(int[][] matrix, int k) {
       /* //构建一个大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2)->n2-n1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                queue.add(matrix[i][j]);
                if(queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.poll();*/
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while(left < right) {
            int mid = left + (right - left) / 2;
            int count = findNotBiggerThanMid(matrix,mid,row,col);
            if(count < k) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }

    private static int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while(i >= 0 && j < col) {
            if(matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j ++;
            }else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i --;
            }
        }
        return count;
    }
}
