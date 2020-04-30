package PSoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李聪
 * @date 2019/12/29 9:24
 */
public class T44 {
    public static void main(String[] args) {

    }
    public boolean isContinuous(int [] numbers) {
        //使用hashSet去重
        // 1. 除0外没有重复的数
        //2. max - min < 5
        Set<Integer> set = new HashSet<>();
        int max = -1,min = 14;
        for (int a : numbers) {
            if(!set.add(a) && a != 0)   //set加入是否成功
                return false;
            if(a != 0) {
                max = Math.max(max,a);
                min = Math.min(min,a);
            }
        }
        if(max - min <= 4)
            return true;
        return false;
     }
}
