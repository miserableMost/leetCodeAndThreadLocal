package Test.April;

/**leetCode:171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...示例 1:输入: "A"
 * 输出: 1
 */
//解题思路，26进制转换为10进制
public class Test171_titleToNumber {
    public static void main(String[] args) {
        Test171_titleToNumber test = new Test171_titleToNumber();
        int res = test.titleToNumber("ZY");
        System.out.println(res);
    }
    public int titleToNumber(String s) {
         /*int len = s.length();
         int sum = 0;
         for(int i=0;i<len;i++){
             //（高位*26+次高位）*26+低位
             sum = (s.charAt(i)-'A'+1)+sum*26;
         }
         return sum;*/
         //从最低位开始算起
         int len = s.length();
         int result = 0;
         int temp = 1;
         for(int i = len-1;i >= 0;i--){
             result += ((s.charAt(i) - 'A') + 1) * temp;
             temp *= 26;
         }
        return result;
    }
}
