package Test.August;

/**
 * leetCode 1005 K 次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *
 * 以这种方式修改数组后，返回数组可能的最大和
 *
 */
public class D3_largestSumAfterKNegations_1005_REMEMBER {
    public static void main(String[] args) {
        int[] A = {2,-3,-1,5,-4};
        int k = 2;
        int i = largestSumAfterKNegations(A, k);
        System.out.println(i);
    }
    public static int largestSumAfterKNegations(int[] A, int K) {
       /* while(K > 0){
            Arrays.sort(A);
            A[0] = -A[0];
            K --;
        }
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        return sum;*/
        int[] number = new int[201];//-100 <= A[i] <= 100,这个范围的大小是201
        for (int t : A) {
            number[t + 100]++;//将[-100,100]映射到[0,200]上
        }
        int i = 0;
        while (K > 0) {
            while (number[i] == 0)//找到A[]中最小的数字
                i++;
            number[i]--;//此数字个数-1
            number[200 - i]++;//其相反数个数+1
            //每次重新处置i
            if (i > 100) {//若原最小数索引>100,则新的最小数索引应为200-i.(索引即number[]数组的下标)
                i = 200 - i;
            }
            K--;
        }
        int sum = 0;
        for (int j = i; j <number.length ; j++) {//遍历number[]求和
            sum += (j-100)*number[j];//j-100是数字大小,number[j]是该数字出现次数.
        }
        return sum;


    }


}
