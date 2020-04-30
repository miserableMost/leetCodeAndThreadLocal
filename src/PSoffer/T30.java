package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/23 16:53
 * 求出1~13的整数中 1 出现的次数,并算出 100~1300 的整数中1出现的次数？为此他特别数了一下 1~13 中包含1的数字有 1、10、11、12、13 因此共出现 6 次,但是对于后面问题他就没辙了。
 * ACMer 希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class T30 {
    public static void main(String[] args) {

    }
    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            sb.append(i);
        }
        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1')
                count ++;
        }
        return count;
    }
}
