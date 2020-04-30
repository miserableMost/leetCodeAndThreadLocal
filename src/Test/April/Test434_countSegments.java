package Test.April;

/**
 * leetCode : 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 示例:输入: "Hello, my name is John"
 * 输出: 5
 */
public class Test434_countSegments {

    public static void main(String[] args) {
        String s = "Hello,my,name is John";
        System.out.println(countSegments(s));
    }

    //这里的单词指的是连续的不是空格的字符。只要不是空格即可
    public static int countSegments(String s) {
        /*if(s.length() == 0 || s==null){
            return 0;
        }
        String [] res = s.split(" ");
        int count = 0;
        for(String n : res){
            if(!"".equals(n)){
                count ++;
            }
        }
        return count;*/
        int count = 0,i = 0;
        int len = s.length();
        while(i<len){
            if(s.charAt(i) != ' '){
                count ++;
            }
            while(i<len&&s.charAt(i)!=' ')
                i++;
            while(i<len&&s.charAt(i)==' ')
                i++;
        }
        return count;
    }
}
