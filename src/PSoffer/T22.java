package PSoffer;

/**
 * @author 李聪
 * @date 2019/12/22 15:21
 */
public class T22 {
    public static void main(String[] args) {

    }
    public boolean VerifySquenceOfBST(int[] sequence)  {
        if(sequence.length == 0)
            return false;
        if(sequence.length == 1)
            return true;
        return isBST(sequence,0,sequence.length - 1);
    }

    private boolean isBST(int[] sequence, int start, int end) {
        if(start < 0 || end < 0 || start >= end)
            return true;
        int rootV = sequence[end];
        int rIndex = -1,rValue = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if(rValue == Integer.MIN_VALUE && sequence[i] > rootV) {
                rValue = sequence[i];
                rIndex = i;
                continue;
            }
            if(rValue != Integer.MIN_VALUE && sequence[i] < rootV)
                return false;
        }
        return isBST(sequence,start,rIndex - 1) && isBST(sequence,rIndex,end - 1);
    }
}
