package Test.August;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 784 : 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 */
public class D2_letterCasePermutation_784_DFS {
    List<String> res = new ArrayList();
    int dis = 'A'-'a';

    public static void main(String[] args) {

    }
    public List<String> letterCasePermutation(String S) {
         if(S.length() == 0)
             return res;
         char[] cs = S.toCharArray();
         dfs(cs,0);
         return res;
    }
    //深度优先搜索
    public void dfs(char[] cs,int idx){
        res.add(String.valueOf(cs));
        for (int i = idx; i < cs.length; i++) {
            if(cs[i] >= '0' && cs[i] <= '9'){
                continue;
            //小写
            } else if(cs[i] >= 'a' && cs[i] <= 'z'){
                cs[i] = (char)(cs[i] + dis);
                dfs(cs,i + 1);
                cs[i] = (char)(cs[i] - dis);
            //大写
            }else{
                cs[i] = (char)(cs[i] - dis);
                dfs(cs,i + 1);
                cs[i] = (char)(cs[i] + dis);
            }
        }
    }
}
