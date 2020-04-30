package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/19 15:00
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy。
 */
public class T2 {
    public String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' ') {
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
