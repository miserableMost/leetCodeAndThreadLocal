package newTest.huisu;

import java.util.ArrayList;
import java.util.List;

public class Test78_subsets {
    public static void main(String[] args) {
        Test78_subsets test = new Test78_subsets();
        int[] sum = {1,2};
        List<List<Integer>> subsets = test.subsets(sum);
        for (List<Integer> subset : subsets) {
            for (Integer i : subset) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //res.add(new ArrayList<>());
        backstack(nums,0,ans,new ArrayList<>());
        return ans;
    }
    public void backstack(int[] nums,int i, List<List<Integer>> ans,List<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for(int j = i;j < nums.length; j ++) {
            temp.add(nums[j]);
            backstack(nums,j + 1,ans,temp);
            temp.remove(temp.size() - 1);
        }
    }
}
