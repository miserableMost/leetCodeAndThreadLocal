package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/23 10:41
 * 超过一半的数字
 */
public class T27 {
    public static void main(String[] args) {
        T27 test = new T27();
        int[] arr = {7,7,1,7,4,5,5,7,7};
        test.MoreThanHalfNum_Solution(arr);
    }
    public int MoreThanHalfNum_Solution(int[] array) {
        int count = 0;
        //声明一个候选人
        Integer candidate = null;
        for (int i : array) {
            if(count == 0){
                candidate = i;
            }
            count += (i == candidate) ? 1 : -1;
        }
        int c = 0;
        for (int i : array) {
            if(i == candidate)
                c ++;
        }
        return c > array.length / 2 ? candidate : 0;
    }
}
