package Test.July;

/**
 * leetCode 1051: 高度检查器
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 *
 */
public class Test1051_heightChecker_31 {
    public static void main(String[] args) {
        int[] height = {1,1,4,2,1,3};
        int i = heightChecker(height);
        System.out.println(i);
    }
    public static int heightChecker(int[] heights) {
       /* //先复制一个数组
        int[] clone = heights.clone();
        //将原数组排序
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != clone[i]){
                count ++;
            }
        }
        return count;*/
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }
}
