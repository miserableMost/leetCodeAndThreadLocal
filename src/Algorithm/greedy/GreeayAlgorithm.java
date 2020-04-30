package Algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class GreeayAlgorithm {
    public static void main(String[] args) {
        //创建广播电台,放入到Map
        HashMap<String,HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
        //将各个电台放入到broadcasts
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        //加入到map
        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        //allAreas 存放所有的地区
        HashSet<String> allAreas = new HashSet<String>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList,存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();
        //定义一个临时的集合，在遍历的过程在，存放遍历过程中的电台覆盖的地区和当前还没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();
        //定义一个maxKey,保存在一次遍历过程中，能够覆盖最大的地区的对应的电台的key
        //如果maxKey不为null,则会加入到selects
        String maxKey = null;
        while(allAreas.size() != 0){
            //每进行一次，需要
            maxKey = null;
            //如果allAreas不为0，则表示还没有覆盖到所有的地区
            //遍历broadcasts,取出对应key
            for (String key : broadcasts.keySet()) {
                //每进行一次for
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet和allAreas集合交集，会赋给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖地区的数量，比maxKey指向的集合未覆盖的地区还多
                //就需要重置maxKey
                //tempSet.size() > broadcasts.get(maxKey).size())
                // 体现贪心算法的特点，每次都选择最优的
                if(tempSet.size() > 0 &&
                        (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size())){
                     maxKey = key;
                }
            }
            //maxKey != null,就应该加入selects
            if(maxKey != null){
                selects.add(maxKey);
                //价格maxKey指向的广播覆盖的地区，从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("刚才选择的是： "+selects);
    }
}
