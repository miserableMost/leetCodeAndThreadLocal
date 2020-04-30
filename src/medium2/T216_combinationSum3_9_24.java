package medium2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class T216_combinationSum3_9_24 {
    public static void main(String[] args) {
        T216_combinationSum3_9_24 test = new T216_combinationSum3_9_24();
        test.combinationSum3(2,18);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
         List<List<Integer>> ans = new ArrayList<>();
         getCombina(k,n,1,ans,new ArrayList<>());
        for (List<Integer> an : ans) {
            for (Integer i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        return ans;
    }
    public void getCombina(int k,int n,int start,List<List<Integer>> ans,List<Integer> cur) {
        //以k为标准
        if(k == 0) {
            if(n == 0)
                ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            getCombina(k - 1,n - i,i + 1, ans,cur);
            cur.remove(cur.size() - 1);
        }
    }

}
