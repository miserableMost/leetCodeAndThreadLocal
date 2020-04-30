package Test.August;

/**
 * leetCode 1010 : 总持续时间可被60整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 */
public class D6_numPairsDivisibleBy60_1010_REMEMBER {
    public static void main(String[] args) {
         int[] time = {30,20,150,100,40};
        int i = numPairsDivisibleBy60(time);
        System.out.println(i);
    }
    public static int numPairsDivisibleBy60(int[] time) {
        /*int count = 0;
        int[] index = new int[60];
        for (int n : time) {
            // 最后还要取模60，是因为(60 - n % 60)的值有可能等于60，而对于我们声明的数组来说，60已经越界了
            count += index[(60 - n % 60) % 60];
            //先判断再相加
            index[n % 60]++;
        }
        return count;*/
        int[] record = new int[60];
        int count = 0;
        for(int t : time){
            t %= 60;        //求这个时间的余数
            if(t != 0)
                count += record[60 - t];    //如果时间余数不为0，找出相加为0的余数总和相加
            //Cn2 = 1 + 2 + 3 + ....+ n - 1
            else count += record[t];        //如果为0，加其他为0的数
            record[t] ++;
        }
        return count;


    }
}
