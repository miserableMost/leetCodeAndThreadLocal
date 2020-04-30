package hard.ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李聪
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 *
 */
public class T386_字典树排数 {
    public static void main(String[] args) {

    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        lexicalOrderDfs(result,null,n);
        return result;
    }

    private void lexicalOrderDfs(List<Integer> result, Integer curValue, int maxNum) {
        if(curValue != null && curValue > maxNum) {
            return;
        }
        if(curValue != null) {
            result.add(curValue);
        }
        for (int nextBit = 0; nextBit < 10; nextBit++) {
            if(curValue == null) {
                if(nextBit == 0) {
                    continue;
                }else {
                    curValue = 0;
                }
            }
            lexicalOrderDfs(result,curValue * 10 + nextBit,maxNum);
        }
    }
}
