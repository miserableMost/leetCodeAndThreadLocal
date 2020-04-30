package Test.August;

/**
 * leetCode 14 :最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class D2_longestCommonPrefix_14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flowe","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs == null || strs.length == 0)
            return sb.toString();
        loop: for (int i = 0; i < strs[0].length(); i++) {
            char first = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                //将第一个字符串的每个字符与后面每个字符串的对应位置字符比较
                if(strs[j].length() <= i ||  first != strs[j].charAt(i)){
                    flag = false;
                    //一旦发现不满足，跳出整个循环
                    break loop;
                }
            }
            if(flag)
                sb.append(first);
        }
        return sb.toString();
    }
}
