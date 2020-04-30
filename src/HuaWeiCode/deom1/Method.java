package HuaWeiCode.deom1;

import java.util.*;

public class Method {

    //fromlist--所有开始from节点
    private Set<Integer> fromlist;

    /**
     * 生成有向图
     * @param list
     * @return
     */
    public HashMap<Integer, Set<Integer>> generateGraph(ArrayList<String> list){
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        fromlist = new HashSet<>();
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
                fromlist.add(from);
            }
            set.add(to);
        }

        return graph;
    }

    public void graphtest(HashMap<Integer, Set<Integer>> graph){
        Iterator it = fromlist.iterator();
        while(it.hasNext()){
            Integer key = (Integer) it.next();
            System.out.println(key+" "+graph.get(key).toString());
        }
    }

    /**
     * 查找所有循环路径
     * @param graph
     * @return
     */
    public ArrayList<ArrayList<Integer>> findCirlePath(HashMap<Integer,Set<Integer>> graph){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        //1.从fromlist中取from节点作为起始节点
        Iterator it = fromlist.iterator();
        while(it.hasNext()){
            Integer from = (Integer) it.next();
            ArrayList<ArrayList<Integer>> li = new ArrayList<>();

            //2.查找从起始节点开始的所有循环路径（可能包含多个）
            path(graph,from,from,li,new ArrayList<Integer>(),new HashSet<Integer>());
            list.addAll(li);

            //3.起始节点用过后就从graph中移除（避免重复）
            graph.remove(from);
        }

        return list;
    }

    /**
     *
     * @param graph
     * @param from
     * @param start 起始节点
     * @param list 结果列表
     * @param li   当前路径列表
     * @param numbers 当前路径包含的节点set集合
     */
    private void path(HashMap<Integer,Set<Integer>> graph, int from, int start, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> li, Set<Integer> numbers){

        //1.判断graph中是否包含from,以及from是否已经遍历过（避免循环）
        if(!graph.containsKey(from) || numbers.contains(from)) return;
        Set toset = graph.get(from);
        li.add(from);
        numbers.add(from);

        //2.如果from指向start，则找到一条循环路径
        if(toset.contains(start)) {
            list.add(new ArrayList<>(li));
            li.remove(li.size()-1);
            numbers.remove(from);
            return;
        }

        //3.没找到，继续遍历
        Iterator it = toset.iterator();
        while(it.hasNext()){
            Integer to = (Integer) it.next();
            path(graph,to,start,list,li,numbers);
        }

        //4.当前from的set遍历完后，从当前路径中移除
        li.remove(li.size()-1);
        numbers.remove(from);

    }

}
