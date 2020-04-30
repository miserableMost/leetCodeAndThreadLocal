package PSoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李聪
 * @date 2019/12/25 20:24
 */
public class T33 {
    public static void main(String[] args) {
        String str = "googgle";
        T33 t33 = new T33();
        int i = t33.FirstNotRepeatingChar(str);
        System.out.println(i);
    }
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return -1;
        Map<Character,Integer> map = new HashMap<>();
        int index = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if(map.containsKey(tmp)) {
                map.put(tmp,100001);
                continue;
            }else {
                map.put(tmp,i);
            }
        }
        if(map.isEmpty())
            return -1;
        for (Character character : map.keySet()) {
            if(map.get(character) < index && map.get(character) != 100001)
                index = map.get(character);
        }
        return index;
    }
}
