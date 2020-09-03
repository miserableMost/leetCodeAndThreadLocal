package tryTest;

import java.util.List;
import java.util.Stack;

/**
 * @author 李聪
 * @date 2020/7/28 22:39
 */
public class 猿辅导3_1 {
    public static void main(String[] args) {

    }
    public static int getMininumCost(int length, List<Character> sequence, List<Integer> cost){
        int res = 0;
        boolean[] visited = new boolean[length + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sequence.size(); i++) {
            if(sequence.get(i) == '('){
                stack.push(i);
            }else {
                //当前为‘）’并且没有'('给你配对
                if(stack.isEmpty()) {
                    res += minCost(cost,visited,0,i);
                }else {
                    stack.pop();
                }
            }
        }
        //栈不为空表示还有很多'('
        while(!stack.isEmpty()) {
            int start = stack.pop() + 1;
            res += minCost(cost,visited,start,length);
        }
        return res;
    }
    public static int minCost(List<Integer> cost,boolean[] visited,int start,int end) {
        int index = -1,min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if(!visited[i]) {
                if(cost.get(i) < min) {
                    min = cost.get(i);
                    index = i;
                }
            }
        }
        visited[index] = true;
        return min;
    }
}
