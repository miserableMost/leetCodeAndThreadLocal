package testAgin;

/**
 * @author 李聪
 * @date 2020/9/16 22:01
 */
public class 大数相减 {
    public static void main(String[] args) {
        System.out.println(bigSub("96", "791"));
    }
    public static String bigSub(String a,String b) {
        char[] arrA = new StringBuilder(a).reverse().toString().toCharArray();
        char[] arrB = new StringBuilder(b).reverse().toString().toCharArray();
        int lenA = arrA.length;
        int lenB = arrB.length;
        int len = Math.max(lenA,lenB);
        char sign = '+';
        if(lenA < lenB){
            sign = '-';
        }else if(lenA == lenB){
            int i = lenA - 1;
            while(i > 0 && arrA[i] == arrB[i]){
                i --;
            }
            if(arrA[i] < arrB[i]){
                sign = '-';
            }
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int arr1 = i < lenA ? (arrA[i] - '0') : 0;
            int arr2 = i < lenB ? (arrB[i] - '0') : 0;
            if(sign == '+'){
                res[i] = arr1 - arr2;
            }else{
                res[i] = arr2 - arr1;
            }
        }
        for (int i = 0; i < res.length - 1; i++) {
            if(res[i] < 0){
                res[i + 1] -= 1;  //借1
                res[i] += 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(sign == '-'){
            sb.append('-');
        }
        //记录连续为0
        boolean flag = true;
        for(int i = len - 1;i >= 0;i --){
            if(res[i] == 0 && flag){
                continue;
            }else {
                flag = false;
            }
            sb.append(res[i]);
        }
        //相等的情况
        if(sb.toString().equals("")){
            sb.append("0");
        }
        return sb.toString();
    }
}
