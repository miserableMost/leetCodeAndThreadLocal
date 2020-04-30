package medium;
/**
 * leetCode 22:括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class T22_generateParenthesis {
    public static void main(String[] args) {

    }
    //只有在我们知道序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
    //
    //如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
    //回溯法
    public List<String> generateParenthesis(int n) {
         List<String> res = new ArrayList<>();
         backtrack(res,"",0,0,n);
         return res;
    }

    public void backtrack(List<String> ans,String cur,int open,int close,int max){
        if(cur.length() == max * 2){
            ans.add(cur);
            return;
        }
        if(open < max)
            backtrack(ans,cur+"(",open + 1,close,max);
        if(close < open)
            backtrack(ans,cur+")",open,close + 1,max);
    }
}
