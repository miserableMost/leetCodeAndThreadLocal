package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 93 : 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class T93_restoreIpAddresses_9_5 {
    public static void main(String[] args) {
        T93_restoreIpAddresses_9_5 test = new T93_restoreIpAddresses_9_5();
        test.restoreIpAddresses("25525511135");

    }
    public List<String> restoreIpAddresses(String s) {
         List<String> ans = new ArrayList<>();
         if(s == null || s.length() == 0)
             return ans;
         dfs(ans,s,"",0,0,s.length() - 1);
         return ans;
    }

    /**
     *
      * @param ans 返回结果
     * @param s    输入字符串
     * @param temp  临时字符串
     * @param count  分为了几部分
     * @param start
     * @param end
     */
    public void dfs(List<String> ans, String s, String temp, int count, int start, int end) {
        //正好四个部分
        if (count == 4) {
            //已经达到末位
            if (start > end) {
                ans.add(new String(temp.substring(0, temp.length() - 1)));
            }
            return;
        }

        for (int i = start; i <= end && start + 3 > i; i++) {
            String substring = s.substring(start, i + 1);
            if (checkValidIp(substring)) {
                dfs(ans, s, temp + substring + ".", count + 1, i + 1, end);
            }
        }

    }
     //检查是否是有效的ip
    public boolean checkValidIp(String str) {

        int m = str.length();
        if (m > 3) {
            return false;
        }
        if (str.charAt(0) == '0') {
            return m == 1;
        }
        return Integer.valueOf(str) <= 255;

    }


}
