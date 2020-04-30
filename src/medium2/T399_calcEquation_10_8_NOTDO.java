package medium2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetCode 399 : 除法求值
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 *
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 *
 * 基于上述例子，输入如下：
 *
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 */
public class T399_calcEquation_10_8_NOTDO {
    public static void main(String[] args) {

    }
    /**
     * 挺复杂的一道题。。。
     * 思路：
     * 1. 根据给出的表达式和关系建立两数相关的map映射（即该数用另一个数如何表示）
     * 2. 待求表达式中第一个数去map中找，数字处理再递归找，找不到就是没有
     * 3. map映射，递归
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> map = new HashMap<>();
        // 处理关系，生成map
        for (int i = 0, len = equations.size(); i < len; i++) {
            String frist = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            // 获取（避免覆盖了，因为关系有多个）
            List<String> fristList = map.getOrDefault(frist, new ArrayList<>());
            List<String> secondList = map.getOrDefault(second, new ArrayList<>());
            fristList.add(values[i] + "_" + second);
            secondList.add(1.0d / values[i] + "_" + frist);
            map.put(frist, fristList);
            map.put(second, secondList);
        }
        //  处理待求表达式
        int len = queries.size();
        double[] result = new double[len];
        for (int i = 0; i < len; i++) {
            String frist = queries.get(i).get(0);
            String second = queries.get(i).get(1);
            // 两数在map中找不到映射
            if (map.get(frist) == null || map.get(second) == null) {
                result[i] = -1.0d;
                continue;
            }
            // 两数相等
            if (frist.equals(second)) {
                result[i] = 1.0d;
                continue;
            }
            result[i] = findRelation(map, frist, second, new ArrayList<>(), 1.0d);
        }
        return result;
    }

    /**
     * 递归，从map中寻找两个数的关系
     *
     * @param map    映射关系
     * @param frist  开头的数
     * @param second 结尾的数
     * @param middle 中间集合，避免产生死循环查找，a找b，b找a
     * @param res    计算结果累计
     * @return frist/second 的值
     */
    private double findRelation(Map<String, List<String>> map, String frist, String second, List<String> middle, double res) {
        for (String s : map.get(frist)) {
            String[] split = s.split("_");
            // 避免死循环，引入的集合
            if (middle.contains(split[1])) {
                continue;
            }
            if (split[1].equals(second)) {
                return Double.parseDouble(split[0]) * res;
            } else {
                // 加入中间集合中
                middle.add(frist);
                double relation = findRelation(map, split[1], second, middle, res * Double.parseDouble(split[0]));
                // 要判断一下，不等于再返回，不然会有特殊情况
                if (relation != -1.0d) {
                    return relation;
                }
            }
        }
        return -1.0d;
    }
}
