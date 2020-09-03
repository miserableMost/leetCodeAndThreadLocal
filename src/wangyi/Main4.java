package wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/8/8 14:44
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cur = sc.nextLine();
            map.put(cur,map.getOrDefault(cur,0) + 1);
        }
        int count = 0;
        double privot = n * 0.01;
        for (String s : map.keySet()) {
            int cur = map.get(s);
            if(cur >= privot) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
