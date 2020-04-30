package Test.August;

/**
 * leetCode 541 : 反转字符串
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。
 * 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 */
public class D13_reverseStr_541 {
    public static void main(String[] args) {
         String s = "kgopo";
        String so = reverseStr(s, 3);
        System.out.println(so);
    }
    public static String reverseStr(String s, int k) {
        int len = s.length();
        //需要进行操作的次数
         int count = len / (2 * k);
         int other = len % (2 * k);
         if(other != 0)
             count += 1;

        char[] arr = s.toCharArray();
        int start = 0;
        for (int i = 0; i < count; i++) {  //i表示第几波操作
            //剩余字符小于k--这一波必然结束
            if(len < k){
                reverse(arr,start,arr.length - 1);
                break;
            }
            //剩余字符小于2*k但大于等于k--这一波必然结束
            if(len < 2 * k && len >= k){
                //翻转前k个字符
                reverse(arr,start,start + k - 1);
                break;
            }
            reverse(arr,start,start + k - 1);
            //剩余字符
            len -= 2 * k;
            //起始位置
            start += 2 * k;

        }
        return new String(arr);
    }
    public static char[] reverse(char[] arr, int l, int r){
        while(l < r){
            char c = arr[l];
            arr[l ++] = arr[r];
            arr[r --] = c;
        }
        return arr;
    }
}
