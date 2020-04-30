package Test.August;

/**
 * leetCode 551 : 学生出勤记录
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 *     'A' : Absent，缺勤
 *     'L' : Late，迟到
 *     'P' : Present，到场
 *
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖
 */
public class D14_checkRecord_551 {
    public static void main(String[] args) {
        boolean ppallp = checkRecord("PPALLL");
        System.out.println(ppallp);
    }
    public static boolean checkRecord(String s) {
        int count = 0;   //记录缺勤的次数
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'A'){
                if(count == 0){
                    count ++;
                }else
                    return false;
            }else if(i < arr.length - 2 && arr[i] == 'L' && arr[i + 1] == 'L' && arr[i + 2] == 'L'){
                return false;
            }

        }
        return true;
    }
}
