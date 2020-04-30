package medium;

import java.util.Arrays;

/**
 * leetCode 274 : H指数
 */
public class T274_hIndex_8_24 {
    public static void main(String[] args) {

    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        //后序遍历
        int i = 0;
        while(i < citations.length && citations[citations.length - 1 - i] > i){
            i ++;
        }
        return i;
    }

}
