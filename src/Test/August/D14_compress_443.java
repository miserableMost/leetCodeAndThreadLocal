package Test.August;

/**
 * leetCode 443: 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 *
 * 压缩后的长度必须始终小于或等于原数组长度。
 *
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *
 * 在完成原地修改输入数组后，返回数组的新长度
 *
 */
public class D14_compress_443 {
    public static void main(String[] args) {
        char[] c = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress = compress(c);
        System.out.println(compress);
    }
    public static int compress(char[] chars) {
         /*char[] clone = chars.clone();
         int len = chars.length;
         char temp = chars[0];
         int count = 1; //出现次数
         int index = 1;
         for (int i = 1; i < len; i++) {
            char c = clone[i];
            if(c == temp){
                count ++;
            //不相等
            }else{
                if(count > 1){
                    *//*String s = Integer.toString(count);
                    for (int j = 0; j < s.length(); j++) {
                        chars[index ++] = s.charAt(j);
                    }*//*
                    add(chars,count,index);
                }
                chars[index ++]  = c;
                count = 1;
                temp = c;
            }
         }
         //看最后一波
        if(count > 1){
            add(chars,count,index);
        }
         System.out.println(Arrays.toString(chars));
         return index;
    }
    public static char[] add(char[] chars,int count,int index){
        String s = Integer.toString(count);
        for (int j = 0; j < s.length(); j++) {
            chars[index++] = s.charAt(j);
        }
        return chars;
    }*/
    //采用滑动窗口
         int left = 0;
         int size = 0;
         for (int right = 0; right <= chars.length; right++) {
             //当遍历完成时
            if(right == chars.length || chars[right] != chars[left]){
                chars[size ++] = chars[left];
                if(right - left > 1){
                    String s = Integer.toString(right - left);
                    for (int j = 0; j < s.length(); j++) {
                        chars[size++] = s.charAt(j);
                    }
                }
                left = right;
            }
         }
         return size;
    }
}
