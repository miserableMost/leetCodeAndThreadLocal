package hard.ByteDance;

import java.util.*;

/**
 * @author 李聪
 * @date 2020/4/5 22:01
 *  给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
 *
 * 区间中的最小数 * 区间所有数的和最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
 */
public class T18 {


    public static void main(String[] args) {



        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] num=new int[n];
        sc.nextLine();
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            //每个值，作为区间min值，找到最大的区间
            int l=i-1;
            while(l>=0){
                if(num[l]>=num[i]){
                    l--;
                }
                else{
                    break;
                }
            }
            //break这个就是不合适的
            l=l+1;
            int r=i+1;
            while(r<n){
                if(num[r]>=num[i]){
                    r++;
                }
                else{
                    break;
                }
            }
            //break这个就是不合适的
            r=r-1;
            int thismax=0;
            for(int j=l;j<=r;j++){
                thismax+=num[j];
            }
            thismax*=num[i];
            max=Math.max(max,thismax);
        }
        System.out.println(max);

    }
    /*public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> lists = new ArrayList<>();
        backtrack(0,arr,lists,new ArrayList<Integer>());
        int a = 0;

        int ans = Integer.MIN_VALUE;
        for (List<Integer> list : lists) {
            if(list == null || list.size() == 0)
                continue;
            Collections.sort(list);
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            ans = Math.max(ans,sum * list.get(0));
        }
        System.out.println(ans);

    }*/


    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

}
