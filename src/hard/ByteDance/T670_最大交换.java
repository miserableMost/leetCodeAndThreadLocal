package hard.ByteDance;

/**
 * @author 李聪
 * @date 2020/3/29 22:01
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 */
public class T670_最大交换 {
    public static void main(String[] args) {
     /*  String s = 8912 + "";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            System.out.print(c + " ");
        }*/
        T670_最大交换 t670 = new T670_最大交换();
        System.out.println(t670.maximumSwap(9973));
    }
    public int maximumSwap(int num) {
        if(num < 10)
            return num;
        char[] arr = (num + "").toCharArray();
        //从后往前记录，在这个位置之后的最大值及其索引
        int[] map = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int max_idx = 0;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if(arr[i] - '0' > max) {
                max = arr[i] - '0';
                max_idx = i;
            }
            map[i] = max_idx;
        }
        //正序从一个数开始遍历，如果它及它以后的最大数不是它本身，那么这个数就是我们需要交换的。
        for (int i = 0; i < arr.length; i++) {
            if(map[i] != i && arr[map[i]] != arr[i]) {
                char temp = arr[i];
                arr[i] = arr[map[i]];
                arr[map[i]] = temp;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(arr));





    }
}
