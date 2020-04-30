package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/27 10:01
 */
public class T36 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,3,3,3,4,5};
        T36 t36 = new T36();
        int i = t36.GetNumberOfK(arr, 3);
        System.out.println(i);
    }
    public int GetNumberOfK(int [] array , int k) {
        return getLast(array,k) - getFirst(array,k) + 1;
    }
    //等于时不断前移
    private int getFirst(int[] array,int k) {
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(array[mid] < k) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return start;
    }
    //等于时不断后移
    private int getLast(int[] array,int k) {
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(array[mid] <= k) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return end;
    }
}
