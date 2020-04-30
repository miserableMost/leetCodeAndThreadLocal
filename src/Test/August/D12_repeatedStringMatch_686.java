package Test.August;

/**
 * leetCode 686 : 重复叠加字符串匹配
 * 给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。
 *
 * 举个例子，A = "abcd"，B = "cdabcdab"。
 *
 * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
 *
 * 注意:
 *
 *  A 与 B 字符串的长度在1和10000区间范围内。
 */
public class D12_repeatedStringMatch_686 {
    public static void main(String[] args) {
         String a = "abcd";
         String b = "cdabcdab";
        int i = repeatedStringMatch(a, b);
        System.out.println(i);
    }
    //必须找到终止条件，返回-1
    // A>B的时候，要么最多叠加2次。 A<B的时候，至少要叠加len(B) / len(A)向上取整
    public static int repeatedStringMatch(String A, String B) {
        int count=1;
        StringBuilder sb = new StringBuilder(A);
        // 因为一个完整的B可能首部用到A的一部分，尾部用到A的一部分，像这样A'[AA....AA]A' , [ ] 内必然<=B的长度，故总长<=2*A+B
        while(sb.length()<2*A.length()+B.length()) {
            //不包含
            if(sb.indexOf(B)==-1) {
                sb.append(A);
                count++;
            }
            else return count;
        }
        return -1;


    }
}
