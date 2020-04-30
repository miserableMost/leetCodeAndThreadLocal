package medium;

/**
 * @author 李聪
 * @date 2020/4/11 13:50
 * 给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
 *
 * 注意：
 *
 * 满足编辑距离等于 1 有三种可能的情形：
 *
 *     往 s 中插入一个字符得到 t
 *     从 s 中删除一个字符得到 t
 *    在 s 中替换一个字符得到 t
 *
 * 示例 1：
 *
 * 输入: s = "ab", t = "acb"
 * 输出: true
 * 解释: 可以将 'c' 插入字符串 s 来得到 t。
 *
 * 示例 2:
 *
 * 输入: s = "cab", t = "ad"
 * 输出: false
 * 解释: 无法通过 1 步操作使 s 变为 t。
 */
public class T161_相隔为1的编辑距离 {
    public static void main(String[] args) {
        T161_相隔为1的编辑距离 t = new T161_相隔为1的编辑距离();
        System.out.println(t.isOneEditDistance("a", ""));

    }
    public boolean isOneEditDistance(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(Math.abs(n1 - n2) > 1)
            return false;
        if(n1 == n2) {
            int count = 0;
            for (int i = 0; i < n1; i++) {
                if(count > 1)
                    return false;
                if(s.charAt(i) != t.charAt(i))
                    count ++;
            }
            return count == 1;
        }else {
            if(n1 < n2) {
                String temp = s;
                s = t;
                t = temp;
            }
            //s永远是长的
            int l = 0,r = 0,count = 0;
            while(l < s.length()) {
                if(count > 1) {
                    return false;
                }
                if(r == t.length()) {
                    count ++;
                    return count == 1;
                }
                if(s.charAt(l) != t.charAt(r)) {
                    l ++;
                    count ++;
                }else {
                    l ++;
                    r ++;
                }

            }
            return count == 1;

        }

    }
}

