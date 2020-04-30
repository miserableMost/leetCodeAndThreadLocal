package PSoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2019/12/29 10:42
 */
public class T49 {
    public static void main(String[] args) {

    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null)
            return false;
        if(numbers.length != length || numbers.length == 0)
            return false;
        boolean flag = false;
        Map<Integer,Integer> map = new HashMap<>();

        for (int number : numbers) {
            if(map.containsKey(number)) {

                //是否是第一次
                if(!flag ) {
                    duplication[0] = number;
                }
                flag = true;

                map.put(number,map.get(number) +1);
            }else {
                map.put(number,1);
            }
        }
        return flag;
    }
}
