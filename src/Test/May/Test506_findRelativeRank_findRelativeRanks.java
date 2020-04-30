package Test.May;

/**
 * leetCode 506:相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * (注：分数越高的选手，排名越靠前。)
 *
 * 示例 1:
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 */
public class Test506_findRelativeRank_findRelativeRanks {
    public static void main(String[] args) {
        int[] nums = {123123,11921,1,0,123};
        String[] ranks = findRelativeRanks(nums);
        for (String s : ranks) {
            System.out.print(s+" ");
        }


    }

    public static String[] findRelativeRanks(int[] nums) {
        int length = nums.length;
        String[] str = new String[length];
        for (int i = 0; i < length; i++) {
            //因为nums均为正数，故此第几次循环获得的就是第几大的值
            int location = max(nums);
            if(i == 0){
                str[location] = "Gold Medal";
            }
            if (i == 1){
                str[location] =  "Silver Medal";
            }
            if (i == 2){
                str[location] =  "Bronze Medal";
            }
            if(i > 2){
                str[location] = i+1+"";
            }
        }
        return str;
    }
    //找出最大数的位置,并将其置为-1.
    public static int max(int[] nums){
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        nums[index] = -1;
        return index;
    }
}
