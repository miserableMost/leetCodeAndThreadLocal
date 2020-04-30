package Test.July;

/**
 * leetCode 997 找到小镇法官
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 *     小镇的法官不相信任何人。
 *     每个人（除了小镇法官外）都信任小镇的法官。
 *     只有一个人同时满足属性 1 和属性 2 。
 *
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *

 */
public class Test997_findJudge_27 {

    public static void main(String[] args) {

    }


    public int findJudge(int N, int[][] trust) {
        //由于法官不相信任何人，因而在trust中的每一项的第一个位置不可能出现法官
        //每个人（除了小镇法官外）都信任小镇的法官。因而法官必然被N-1个人信任
         //定义一个二维数组，其中每个以为数组长度为2，每个一维数组的位置-1代表1-N
        //一位数组的第一项若为法官必为0否则即代表在trust出现，此时法官有了信任的人，与题意不符，可理解为你相信的人的个数，第二项表示信任他的人数
        //N表示总人数
        int[][] res = new int[N][2];
        for (int[] people : trust) {
            res[people[0] - 1][0] ++;
            res[people[1] - 1][1] ++;
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i][0] == 0 && res[i][1] == N - 1){
                return i + 1;
            }
        }
        return -1;
    }
}
