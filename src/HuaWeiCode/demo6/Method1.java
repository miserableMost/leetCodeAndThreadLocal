package HuaWeiCode.demo6;

import java.util.*;

public class Method1 {

    private HashMap<Integer, Node> map = new HashMap<>();
    private TreeSet<Node> set = new TreeSet<>();
    private int path_indegree_total = 0;

    public TreeSet<Node> getSet() {
        return set;
    }

    public void generateGraph(ArrayList<String> list){

        for(String str : list) {
            int indx1 = 0;
            while (str.charAt(indx1) != ',') indx1++;
            int indx2 = indx1 + 1;
            while (str.charAt(indx2) != ',') indx2++;
            int from = Integer.valueOf(str.substring(0, indx1));
            int to = Integer.valueOf(str.substring(indx1 + 1, indx2));

            //from节点
            Node fromnode;
            TreeSet<Node> toset;
            if(map.containsKey(from)){
                fromnode = map.get(from);
                toset = fromnode.getToSet();
            }else {
                fromnode = new Node(from);
                toset = new TreeSet<>();
                fromnode.setToSet(toset);
                map.put(from,fromnode);
                set.add(fromnode);
            }
            //to节点
            Node tonode;
            if(map.containsKey(to)){
                tonode = map.get(to);
            }else {
                tonode = new Node(to);
                tonode.setToSet(new TreeSet<>());
                map.put(to,tonode);
                set.add(tonode);
            }
            //to节点入度加1
            tonode.setIndegree(tonode.getIndegree()+1);
            //from节点指向to节点
            toset.add(tonode);

        }
        System.out.println();
    }


    public ArrayList<ArrayList<Integer>> findLoopPath(){
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Node node = (Node) iterator.next();
            //入度为0的节点跳过
            if(node.getIndegree()==0){
                continue;
            }else {

                path_indegree_total = 0;        //当前路径包含节点的总入度值
                path(lists,new ArrayList<>(),node,node,1);
                //起始节点入度置0
                node.setIndegree(0);
            }
        }
        return lists;
    }

    private void path(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, Node fromnode, Node start, int depth){
        //深度大于7返回
        if(depth>7 || fromnode.getIndegree()<1) return;
        list.add(fromnode.getVal());

        //当前路径总入度
        path_indegree_total += fromnode.getIndegree();
        Set<Node> toset = fromnode.getToSet();

        //找到循环序列
        if(toset.contains(start)) {
            if(depth>2) lists.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            //返回时，总入度减去当前节点的入度
            path_indegree_total -= fromnode.getIndegree();
            return;
        }

        //没找到，继续向下遍历
        Iterator iterator = toset.iterator();
        while (iterator.hasNext()){
            Node node = (Node) iterator.next();
            path(lists,list,node,start,depth+1);
        }

        //递归返回时，当前总入度等于路径深度时，当前节点不再可用，入度置0，表示移除
        int indegree = fromnode.getIndegree();
        if(path_indegree_total==depth) fromnode.setIndegree(0);
        ////返回时，总入度减去当前节点的入度
        path_indegree_total -= indegree;

        list.remove(list.size()-1);
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
