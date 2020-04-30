package Test.August;

/**
 * leetCode 66 :加一
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class D10_plusOne_66 {
    public static void main(String[] args) {

    }
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9)
            {
                digits[i]+=1;
                return digits;
            }
            else
            {
                digits[i]=0;
            }

        }
        //全部为9则需要扩容
        int[] ans=new int[digits.length+1];
        ans[0]=1;
        return digits;

    }

}
