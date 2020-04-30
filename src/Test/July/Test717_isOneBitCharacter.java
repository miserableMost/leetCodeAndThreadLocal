package Test.July;

import java.util.Arrays;

/**
 *leetCode 717: 1比特与2比特字符
 *
 */
public class Test717_isOneBitCharacter {
    public static void main(String[] args) {
        int[] bits = {1,0,0};
        String s = Arrays.toString(bits);
        System.out.println(s);
    }



    //最后一个一定是0，那么从倒数第二个往前遍历，直到遇到前一个0或者到数组头
    //记录中间遇到的1的个数。 因为两比特有0的情况只有10，那么假如中间遇到的1的个数是奇数
    //则最后一个0不为一比特，是偶数为一比特。
    public boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        int length = bits.length;
        for (int i = length - 2; i >= 0 ; i--) {
            if(bits[i] == 1){
                count++;
            }else{
                break;
            }
        }
        return count % 2 == 0;

    }
}
