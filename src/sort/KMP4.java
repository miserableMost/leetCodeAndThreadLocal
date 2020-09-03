package sort;

/**
 * @author 李聪
 * @date 2020/8/12 22:47
 */
public class KMP4 {
    public static void main(String[] args) {
        int kmp = kmp("assdfgghh", "sdf");
        System.out.println(kmp);
    }

    public static int kmp(String s,String sub){
        int[] next = getNext(sub);
        int i = 0,j = 0,index = -1;
        while(i < s.length() && j < sub.length()){
            if(s.charAt(i) == sub.charAt(j)){
                i ++;
                j ++;
            }else if(j == 0){
                i ++;
            }else {
                j = next[j];
            }
        }
        if(j == sub.length()){
            index = i - sub.length();
        }
        return index;
    }
    public static int[] getNext(String sub){
        int[] next = new int[sub.length()];
        next[0] = 0;
        next[1] = 0;
        int j = 1,k = 0;
        while(j < sub.length() - 1) {
            if(sub.charAt(j) == sub.charAt(k)) {
                next[j + 1] = k + 1;
                j ++;
                k ++;
            }else if(k == 0){
                next[j + 1] = 0;
                j ++;
            }else{
                k = next[k];
            }
        }
        return next;
    }

}
