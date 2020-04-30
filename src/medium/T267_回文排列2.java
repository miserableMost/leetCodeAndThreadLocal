package medium;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/4/11 18:43
 * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 *
 * 如不能形成任何回文排列时，则返回一个空列表。
 *
 * 示例 1：
 *
 * 输入: "aabb"
 * 输出: ["abba", "baab"]
 *
 * 示例 2：
 *
 * 输入: "abc"
 * 输出: []
 *
 */
public class T267_回文排列2 {
    public static void main(String[] args) {
        T267_回文排列2 t = new T267_回文排列2();
        List<String> aabb = t.generatePalindromes("aabb");
        for (String s : aabb) {
            System.out.println(s);
        }
    }
    public List<String> generatePalindromes(String s) {
        Set<String> set = new HashSet<>();
        //List<String> ans = new ArrayList<>();
        boolean[] isVisted = new boolean[s.length()];
        dfs(set,s,0,new StringBuilder(),isVisted);
        return new ArrayList<>(set);
    }

    private void dfs(Set<String> ans, String s,int size, StringBuilder sb,boolean[] isVisted) {
        if(size == s.length()) {
            if(isPalin(sb.toString(),0,sb.toString().length() - 1) ) {
                ans.add(sb.toString());
            }
            return;
        }
        for (int j = 0; j < s.length(); j++) {

            if(!isVisted[j]) {
                sb.append(s.charAt(j));
                isVisted[j] = true;
                dfs(ans,s,size + 1,sb,isVisted);
                sb.delete(sb.length() - 1,sb.length());
                isVisted[j] = false;
            }

        }

    }


    //判断是否是回文
    private boolean isPalin(String s,int i,int j) {
        int l = i;
        int r = j;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }

    /**
     * 思路: 先用判断能否构成回文序列,不可以就直接返回空数组
     * 可以的话看回文序列长度是否为奇数,为奇数的话把奇数字符查出来,
     * 然后在map中把这个key对应个数减1,为偶数的话就不管
     * 由于回文序列是两边对称的,所以我只计算一边的全排列,计算
     * 完了之后再加上他的反序列即可,当然，有奇数字符就把它加到中间。
     *
     * @param s
     * @return
     */
    public List<String> generatePalindromes2(String s) {

        if (s.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        int size = 0;
        Character ch = null;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                ch = key;
                count += 1;
                map.put(key, map.get(key) - 1);
            }
            size += map.get(key) / 2;
        }

        if (count > 1) {
            return new ArrayList<>();
        }

        char[] chars = new char[size];
        int i = 0;
        for (char key : map.keySet()) {
            for (int j = 0; j < map.get(key) / 2; j++) {
                chars[i++] = key;
            }
        }

        boolean[] visited = new boolean[size];
        List<String> resultList = new ArrayList<>();
        dfs(chars, visited, new StringBuilder(), resultList, ch);

        return resultList;

    }

    private void dfs(char[] chars, boolean[] visited, StringBuilder sb,
                     List<String> resultList, Character ch) {

        if (sb.length() == chars.length) {
//            String reverse = "";
//            for (int i = tmp.length() - 1; i >= 0; i--) {
//                reverse += tmp.charAt(i);
//            }
            StringBuilder tmp = new StringBuilder(sb.toString());
            String reverse = new StringBuilder(sb.toString()).reverse().toString();
            //ch用来判断奇偶
            resultList.add(ch == null ? tmp.append(reverse).toString() : tmp.append(ch).append(reverse).toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            } else {
                if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                    continue;
                }
                sb.append(chars[i]);
                visited[i] = true;
                dfs(chars, visited, sb, resultList, ch);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }


}
