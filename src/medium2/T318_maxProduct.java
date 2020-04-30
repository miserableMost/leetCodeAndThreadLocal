package medium2;

/**
 * @author 李聪
 * @date 2019/12/12 18:03
 *
 *给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *leetCode 318. 最大单词长度乘积
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 *
 */
public class T318_maxProduct {
    /**
     全是小写字母, 可以用一个32位整数表示一个word中出现的字母,
     hash[i]存放第i个单词出现过的字母, a对应32位整数的最后一位,
     b对应整数的倒数第二位, 依次类推. 时间复杂度O(N^2)
     判断两两单词按位与的结果, 如果结果为0且长度积大于最大积则更新
     **/
    public int maxProduct(String[] words) {
        int len = words.length;
        //先转为int
        int[] arr = new int[len];
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            for (int j = 0; j < length; j++) {
                arr[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        //与为0则表示重复
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if((arr[i] & arr[j]) == 0)
                    ans = Math.max(ans,words[i].length() * words[j].length());
            }
        }
        return ans;

    }
}
