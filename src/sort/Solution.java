package sort;

import java.util.HashMap;

/**
 * @author 李聪
 * @date 2020/4/29 11:27
 */
public class Solution {
    public static void main(String[] args) {

    }
    public int longestIp(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        UnionFind uf = new UnionFind(nums);
        for (int i = 0; i < nums.length; i++) {
            if(uf.fatherMap.containsKey(nums[i] - 1)) {
                uf.union(nums[i],nums[i] - 1);
            }
        }
        return uf.max;
    }

    class UnionFind {
        int max;
        HashMap<Integer,Integer> fatherMap;
        HashMap<Integer,Integer> sizeMap;

        public UnionFind(int[] nums) {
            max = 1;
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (int num : nums) {
                fatherMap.put(num,num);
                sizeMap.put(num,1);
            }
        }
        public int findFather(int val) {
            int father = fatherMap.get(val);
            if(father != val) {
                father = findFather(father);
            }
            fatherMap.put(val,father);
            return father;
        }
        public void union(int a,int b) {
            int fatherA = findFather(a);
            int fatherB = findFather(b);
            if(fatherA != fatherB) {
                //获取他们的大小
                int sizeA = sizeMap.get(fatherA);
                int sizeB = sizeMap.get(fatherB);
                if(sizeA <= sizeB) {
                    fatherMap.put(fatherA,fatherB);
                    sizeMap.put(fatherB,sizeA + sizeB);
                }else {
                    fatherMap.put(fatherB,fatherA);
                    sizeMap.put(fatherA,sizeA + sizeB);
                }
                max = Math.max(max,sizeA + sizeB);

            }
        }
    }
}
