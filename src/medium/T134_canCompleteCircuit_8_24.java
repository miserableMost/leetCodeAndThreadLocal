package medium;

/**
 * leetCode 134:加油站
 *在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 */
public class T134_canCompleteCircuit_8_24 {
    public static void main(String[] args) {

    }
    //数学定理：
    //如果一个数组的总和非负，那么一定可以找到一个起始位置，从他开始绕数组一圈，累加和一直保持非负。
    //因为如果i到j的剩余油量小于0，而i显然油量大于0，那么从i+1到j就必定更小，同理，i+2,i+3也不用考虑，所以就应该直接从j+1开始继续遍历，并保存之前欠缺的油量总和。
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int cur_tank = 0;
        int total_tank = 0;
        int start_station = 0;
        for (int i = 0; i < n; i++) {
            cur_tank += gas[i] - cost[i];
            total_tank += gas[i] - cost[i];
            if(cur_tank < 0){
                start_station = i + 1;
                cur_tank = 0;
            }
        }
        return total_tank >= 0 ?start_station : -1;
    }
}
