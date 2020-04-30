package HuaWeiCode.demo3;

import java.util.*;

public class Method3 {

    //所有节点
    private Set<Integer> all_list = new TreeSet<>();;
    //graph_indegree-存放所有节点元素及其入度
    private HashMap<Integer,Integer> graph_indegree = new HashMap<>();
    //有向图
    private HashMap<Integer, Set<Integer>> graph = new HashMap<>();

    /**
     * *生成有向图
     * * @param list
     * @return
     */
    public HashMap<Integer, Set<Integer>> generateGraph(ArrayList<String> list){
        for(String str : list){
            int indx1 = 0;
            while(str.charAt(indx1)!=',') indx1++;
            int indx2 = indx1+1;
            while(str.charAt(indx2)!=',') indx2++;
            int from = Integer.valueOf(str.substring(0,indx1));
            int to = Integer.valueOf(str.substring(indx1+1,indx2));
            Set<Integer> set;
            if(graph.containsKey(from)){
                set = graph.get(from);
            }else {
                set = new HashSet<>();
                graph.put(from,set);
                if(!graph_indegree.containsKey(from)) graph_indegree.put(from,0);
            }
            set.add(to);
            all_list.add(from);
            if(graph_indegree.containsKey(to)){
                graph_indegree.put(to,graph_indegree.get(to)+1);
            }else {
                graph_indegree.put(to,1);
            }
        }
        return graph;
    }

    /**
     * 查找所有循环路径
     * @param
     * @return
     */
    public ArrayList<ArrayList<Integer>> findCirlePath(){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        //1.从all_list中取节点作为起始节点
        Iterator it = all_list.iterator();
        while (it.hasNext()){
            Integer from = (Integer) it.next();
            if(!graph.containsKey(from)) continue;

            //起始节点入度为0时，直接启动移除节点的方法
            //起始节点入度不为0时，先查找，再启动移除节点的方法
            if(graph_indegree.get(from)>0){
                //查找从起始节点开始的所有循环路径（可能包含多个）
                path(from,from,list,new ArrayList<Integer>(),new HashSet<Integer>());
            }

            //移除起始节点以及后续节点
            Set<Integer> to = graph.get(from);
            graph.remove(from);
            graph_indegree.remove(from);
            remove_node(to);
        }
        return list;
    }

    //节点移除
    private void remove_node(Set<Integer> set){
        Iterator it = set.iterator();
        while (it.hasNext()){
            Integer node = (Integer) it.next();
            //当前节点入度大于1时，入度减1
            if(graph_indegree.containsKey(node) && graph_indegree.get(node)>1){
                graph_indegree.put(node,graph_indegree.get(node)-1);
            }else {
                //当前入度为1时，当前节点可移除
                if(graph.containsKey(node)) remove_node(graph.get(node));
                graph.remove(node);
                graph_indegree.remove(node);
            }
        }
    }

    /**
     *
     * @param
     * @param from
     * @param start 起始节点
     * @param list 结果列表
     * @param li   当前路径列表
     * @param depth 当前路径包含的节点set集合
     */
    private void path(int from, int start, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> li, Set<Integer> depth){

        //1.判断graph中是否包含from,以及from是否已经遍历过（避免死循环）
        if(!graph.containsKey(from) || depth.contains(from) || li.size()>=7) return;
        Set toset = graph.get(from);
        li.add(from);
        depth.add(from);

        //2.如果from指向start，则找到一条循环路径
        if(toset.contains(start)) {
            //路径长度大于2则加入列表
            if(li.size()>2)list.add(new ArrayList<>(li));
            li.remove(li.size()-1);
            depth.remove(from);
            return;
        }

        //3.没找到，继续遍历
        Iterator it = toset.iterator();
        while(it.hasNext()){
            Integer to = (Integer) it.next();
            path(to,start,list,li,depth);
        }

        //4.当前from的set遍历完后，从当前路径中移除
        li.remove(li.size()-1);
        depth.remove(from);

    }

    public ArrayList<Integer>[] sortList(ArrayList<ArrayList<Integer>> lists){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer>[] arr = lists.toArray(new ArrayList[lists.size()]);
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j].size()>arr[j+1].size()){
                    ArrayList<Integer> temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    //字典序排序
    public void sortByDic(ArrayList<ArrayList<Integer>> list) {
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() == o2.size()) {
                    int i = 0;
                    while(i <= o1.size() && o1.get(i) == o2.get(i)) {
                        i ++;
                    }
                    if(i > o1.size()) {
                        return 0;
                    }else {
                        return o1.get(i) - o2.get(i);
                    }
                }else {
                    return o1.size() - o2.size();
                }

            }
        });

    }


}
