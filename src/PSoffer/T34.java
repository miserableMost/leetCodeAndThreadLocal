package PSoffer;



/**
 * @author 李聪
 * @date 2019/12/25 20:40
 */
public class T34 {
    public static void main(String[] args) {
        int[] nums = {4,1,3,2,6,8,7};
        T34 t34 = new T34();
        int i = t34.InversePairs(nums);
        System.out.println(i);
    }
    public int InversePairs(int [] array) {
        //定义一个总数
        if(array == null || array.length == 0)
            return 0;
        return mergeSort(array,0,array.length - 1);
    }

    private int mergeSort(int[] array, int start, int end) {
        if(start == end)
            return 0;
        int mid = start + (end - start) / 2;
        int L = mergeSort(array,start,mid);
        int R = mergeSort(array,mid + 1,end);
        return (merge(array,start,mid,end) + L + R)% 1000000007;
    }

    private int merge(int[] array, int start, int mid, int end) {
        int count = 0;
        int i = start,j = mid + 1;
        int idx = start;
        int[] help = new int[array.length];
        while(i <= mid || j <= end) {
            int value1 = i > mid ? array[i] : Integer.MIN_VALUE;
            int value2 = j > end ? array[j] : Integer.MIN_VALUE;
            if(value1 <= value2){
                help[idx ++] = array[i++];
            }else {
                help[idx ++] = array[j++];
                count += mid + 1 - i;
                if(count > 1000000007)
                    count %= 1000000007;
            }
        }
        int a = 0,b = 0;
        for (int k = 0; k < array.length; k++) {
            array[a ++] = help[b ++];
        }
        return count%1000000007;
    }



}
