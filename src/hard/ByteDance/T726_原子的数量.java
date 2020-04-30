package hard.ByteDance;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 李聪
 * @date 2020/3/29 19:26
 *
 *给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 *示例 1:
 *
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 *
 * 示例 2:
 *
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 *
 * 示例 3:
 *
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *
 */
public class T726_原子的数量 {
    int i;
    public static void main(String[] args) {
        int i = 0;
        int s = i ++;
        System.out.println(s);
    }
    public String countOfAtoms(String formula) {
        StringBuilder ans = new StringBuilder();
        //用一个map存放
        i = 0;
        Map<String,Integer> count = parse(formula);
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            ans.append(entry.getKey());
            if(entry.getValue() > 1)
                ans.append("" + entry.getValue());
        }
        return ans.toString();
    }

    private Map<String, Integer> parse(String formula) {
        int N = formula.length();
        Map<String,Integer> count = new TreeMap<>();
        while(i < N && formula.charAt(i) != ')') {
            if(formula.charAt(i) == '(') {
                i ++;
                for (Map.Entry<String, Integer> entry : parse(formula).entrySet()) {
                    count.put(entry.getKey(), count.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
            }else {
                int iStart = i++;
                //提出这个字符Mg
                while(i < N && Character.isLowerCase(formula.charAt(i)))
                    i ++;
                String name = formula.substring(iStart,i);
                iStart = i;
                //提取数字
                while(i < N && Character.isDigit(formula.charAt(i)))
                    i ++;
                //如果i没有移动，则表示此元素为1
                int mul = iStart < i ? Integer.parseInt(formula.substring(iStart,i)) : 1;
                count.put(name,count.getOrDefault(name,0) + mul);
            }
        }
        //乘以括号外系数
        int iStart = ++i;
        //提取出括号外的系数
        while(i < N && Character.isDigit(formula.charAt(i)))
            i ++;
        if(iStart < i) {
            int mul = Integer.parseInt(formula.substring(iStart,i));
            for (String key : count.keySet()) {
                count.put(key,count.get(key) * mul);
            }
        }
        return count;
    }
}
