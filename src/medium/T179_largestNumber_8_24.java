package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetCode 179:最大数
 *  给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 */
public class T179_largestNumber_8_24 {
    public static void main(String[] args) {

    }
    public String largestNumber(int[] nums) {
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        if(ans[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String an : ans) {
            sb.append(an);
        }
        return sb.toString();
    }
}
