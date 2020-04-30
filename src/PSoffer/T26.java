package PSoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 李聪
 * @date 2019/12/23 9:57
 */
public class T26 {
    public static void main(String[] args) {

    }
    public ArrayList<String> Permutation(String str) {
        Set<String> res = new HashSet<>();
        if(str == null || str.length() == 0)
            return new ArrayList<>();
        permu(res,str.toCharArray(),0);
        ArrayList<String> list = new ArrayList<>(res);
        //利用string的比较方法
        list.sort(String::compareTo);
        return list;
    }

    private void permu(Set<String> res, char[] chars, int start) {
        if(start == chars.length){
            res.add(new String(chars));
            return;
        }
        for (int i = start; i < chars.length; i++) {
            swap(chars,start,i);
            permu(res,chars,i + 1);
            //递归回溯，交换过去后，交换回来
            swap(chars,start,i);
        }

    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
