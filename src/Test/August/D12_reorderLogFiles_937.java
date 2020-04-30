package Test.August;

import java.util.Arrays;

/**
 * leetCode 937 : 重新排列日志文件
 * 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
 *
 * 对于每条日志，其第一个字为字母数字标识符。然后，要么：
 *
 *     标识符后面的每个字将仅由小写字母组成，或；
 *     标识符后面的每个字将仅由数字组成。
 *
 * 我们将这两种日志分别称为字母日志和数字日志。保证每个日志在其标识符后面至少有一个字。
 *
 * 将日志重新排序，使得所有字母日志都排在数字日志之前。字母日志按内容字母顺序排序，忽略标识符；在内容相同时，按标识符排序。数字日志应该按原来的顺序排列。
 *
 * 返回日志的最终顺序
 */
public class D12_reorderLogFiles_937 {
    public static void main(String[] args) {
        //Lambda表达式
         new Thread( () -> {
             System.out.println("多线程启动了");
         }).start();
    }
    public String[] reorderLogFiles(String[] logs) {
        //有一个接口，接口中只有一个抽象方法
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;


    }
}
