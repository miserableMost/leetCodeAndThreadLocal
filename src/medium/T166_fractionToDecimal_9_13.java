package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 166 ：分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 示例 1:
 *
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 *
 * 示例 2:
 *
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 *
 * 示例 3:
 *
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 *
 */
public class T166_fractionToDecimal_9_13 {
    public static void main(String[] args) {

    }
    public String fractionToDecimal(int numerator, int denominator) {
      if(numerator == 0)
          return "0";
      StringBuilder fraction = new StringBuilder();
      //只能有一个满足
      if(numerator < 0 ^ denominator < 0) {
          fraction.append("-");
      }
      Long dividend = Math.abs(Long.valueOf(numerator));
      Long divisor = Math.abs(Long.valueOf(denominator));
      fraction.append(String.valueOf(dividend / divisor));
      Long remainder = dividend % divisor;
      if(remainder == 0)
          return fraction.toString();
      fraction.append(".");
      Map<Long,Integer> map = new HashMap<>();
      while(remainder != 0) {
          if(map.containsKey(remainder)) {
              fraction.insert(map.get(remainder),"(");
              fraction.append(")");
              break;
          }
          map.put(remainder,fraction.length());
          remainder *= 10;
          fraction.append(String.valueOf(remainder / divisor));
          remainder %= divisor;
      }
      return fraction.toString();
    }
}
