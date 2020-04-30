package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李聪
 * @date 2020/4/15 17:53
 * 给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可以持续进行 “移位” 操作，从而生成如下移位序列：
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 *
 * 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。
 *
 * 示例：
 *
 * 输入: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
 * 输出:
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 */
public class T249_移位字符串分组 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if(strings == null || strings.length == 0)
            return res;
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            StringBuffer sb = new StringBuffer();
            String cur = strings[i];
            for (char c : cur.toCharArray()) {
                sb.append("#");
                int dif = (c - cur.charAt(0) + 26) % 26;
                sb.append(dif + ",");
            }
            if(!map.containsKey(sb.toString())) {
                map.put(sb.toString(),new ArrayList<>());
            }
            map.get(sb.toString()).add(cur);

        }

        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
