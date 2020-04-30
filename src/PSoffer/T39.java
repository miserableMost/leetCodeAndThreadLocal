package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/27 19:18
 */
public class T39 {
    public static void main(String[] args) {

    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int ans = 0;
        for (int i : array) {
            ans ^= i;
        }
        int idx = 0;      //记录ans中第一个1的位置
        while(idx < 32) {
            if((ans & (1 << idx)) != 0) {
                break;
            }
            idx ++;
        }
        num1[0] = 0;
        num2[0] = 0;
        //将这两个数分成两组
        for (int i = 0; i < array.length; i++) {
            if((array[i] & (1 << idx)) != 0) {
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }
}
