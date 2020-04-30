package Test.August;

/**
 * leetCode 1041 : 困于环中的机器人
 *
 */
public class D13_isRobotBounded_1041 {
    public static void main(String[] args) {

    }
    //看是否被困，就看运行完指令是否回到原点即可。 按最少命令的情况算有: 1.L ：
    // 原地罚站。 2.GLL: 执行两次该命令就会回到原点。 3.GL：执行四次该命令就会回到原点。 这样我们只需要最多重复四次命令，其中若有任何一次执行完回到原点，那机器人就被困在环中了。 其中方向：北东南西->0,1,2,3。
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, currDir = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                char ch = instructions.charAt(j);
                if (ch == 'G') {
                    x = currDir == 1 ? x + 1 : (currDir == 3 ? x - 1 : x);
                    y = currDir == 0 ? y + 1 : (currDir == 2 ? y - 1 : y);
                }
                else if (ch == 'R')
                    currDir = currDir == 3 ? 0 : currDir + 1;
                else
                    currDir = currDir == 0 ? 3 : currDir - 1;
            }
            if (x == 0 && y == 0)
                return true;
        }
        return false;
    }
}
