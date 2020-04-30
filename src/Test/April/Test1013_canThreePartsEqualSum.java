package Test.April;

/**
 * leetCode: 1013. 将数组分成和相等的三个部分
 * 给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 */
public class Test1013_canThreePartsEqualSum {
    public static void main(String[] args) {
        int[] a = {3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(canThreePartsEqualSum(a));
    }


    public static boolean canThreePartsEqualSum(int[] A) {
          int len = A.length;
          int sum = 0;
          int index1 = 0,index2 = 0;
          //先计算总和
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }
        //检查是否能三等分
        if(sum % 3 != 0){
            return false;
        }else{
            //进行第一次分
            //index1 = rearch(0,len,sum,A,index1);
            int sum1 = 0;
            for(int i = 0; i < len; i++) {
                sum1 += A[i];
                if(sum1 == sum/3) {
                    index1 = i;
                    break;
                }
            }
            //进行第二次分
            //index2 = rearch(index1+1,len,sum,A,index2);
            int sum2 = 0;
            for(int i = index1+1;i<len;i++){
                sum2 += A[i];
                if(sum2 == sum/3){
                    index2 = i;
                    break;
                }
            }
            //确保能三等分
            if(index1 < index2 && index2 < len-1){
                return true;
            }
        }
        return false;
    }


    //查找分界点方法
    /*public static int rearch(int begin,int end,int sum,int[] A,int index){
        int sumX = 0;
        for (int i = begin; i < end; i++) {
            sumX += A[i];
            if(sumX == sum/3){
                index = i;
                return index;
            }
        }
        return  end-1;
    }*/
}
