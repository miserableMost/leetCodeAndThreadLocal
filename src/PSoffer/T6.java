package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/19 15:49
 * 旋转数组的最小数字
 */
public class T6 {
    public int minNumberInRotateArray(int[] array) {
        if(array.length == 0)
            return 0;
        //定义两个指针，找到前面升序部分的最大值和后面升序部分的最小值
        int start = 0;
        int end = array.length - 1;
        //刚刚好start和end相连
        while(end - start != 1) {
            int mid = start + (end - start) / 2;
            //前一部分有序
            if(array[mid] >= array[start]) {
                //处在前一部分
                start = mid;
            }
            //后一部分有序
            if(array[mid] <= array[end]) {
                ///处在后一部分
                end = mid;
            }
        }
        return array[end];
    }
}
