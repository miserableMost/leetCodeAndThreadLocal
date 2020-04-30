package hard.ByteDance;

/**
 * @author 李聪
 * @date 2020/3/30 9:40
 */
public class T351_安卓系统手势解锁 {
    
    //使用一个数组判断是否使用
    private boolean[] used = new boolean[9];
    public static void main(String[] args) {
        System.out.println((2%3 != 8 % 3) && (2/3 != 8/3));
    }

    //注意索引是0-8
    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int len = m; len <= n; len++) {
            res += calPattern(-1,len);
            //每一次都要将数组回归
            for (int i = 0; i < 9; i++) {
                used[i] = false;
            }
        }
        return res;
    }

    private int calPattern(int last, int len) {
        if(len == 0)
            return 1;
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if(isValid(i,last)) {
                used[i] = true;
                //操作一波数变少一个，last变为i
                sum += calPattern(i,len - 1);
                used[i] = false;
            }
        }
        return sum;
    }

    private boolean isValid(int index, int last) {
        if(used[index])
            return false;
        if(last == -1)
            return true;
        //走马字或者相邻
        if((index + last) % 2 == 1)
            return true;
        //如果是大对角线
        int mid = (index + last) / 2;
        if(mid == 4)
            return used[mid];
        //小对角--斜方向
        if ((index%3 != last%3) && (index/3 != last/3)) {
            return true;
        }
        //边长移动--1-7
        return used[mid];
    }
}
