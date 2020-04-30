package HuaWeiCode.demo6;

import java.util.*;

public class Method3 {
    //map-辅助生成有向图
    private HashMap<Integer, Node> map = new HashMap<>();
    //存放所有节点，从小到大排序
    private TreeSet<Node> set = new TreeSet<>();

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
            if(node.getIndegree()==0){
                //入度为0的起始节点，直接用fnc()方法更新后续节点的入度值
                fnc(node.getToSet());
                continue;
            }else {
                path(lists,new ArrayList<>(),node,node,1);
                //起始节点查找一次后，就可移除
                node.setIndegree(0);
                fnc(node.getToSet());
            }
        }
        return lists;
    }

    //从入度为0的节点开始，更新相关节点入度值
    private void fnc(Set<Node> set){
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Node node = (Node) iterator.next();
            //当前节点入度为1，可以移除，继续向下遍历
            if(node.getVal()==1) fnc(node.getToSet());
            //当前节点入度减一
            node.setIndegree(node.getIndegree()-1);
        }
    }

    //使用广度优先搜索
    private void pathBfs(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, Node fromnode, Node start) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);
        int depth = 1;
        Set<Node> visited = new HashSet<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(depth > 7)
                return;
            //新建size个list
            List<Integer>[] listcur = new ArrayList[size];
            for (int j = 0; j < size; j++) {
                listcur[j] = new ArrayList<>();
            }
            //每个list必须加上之前的元素

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                visited.add(cur);
                listcur[i].add(cur.getVal());
                Set<Node> toset = cur.getToSet();
                if(toset.contains(start) && depth > 2) {
                    lists.add(new ArrayList<>(listcur[i]));
                }else {
                    Iterator<Node> it = toset.iterator();
                    while(it.hasNext()) {
                        Node next = it.next();
                        if(!visited.contains(next)) {
                            queue.add(next);
                        }
                    }
                }
            }
            depth ++;
        }
    }


    private void path(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, Node fromnode, Node start, int depth){
        //深度大于7返回
        if(depth>7 || fromnode.getIndegree()<1 ) return;
        list.add(fromnode.getVal());

        //当前路径总入度
//        path_indegree_total += fromnode.getIndegree();
        Set<Node> toset = fromnode.getToSet();

        //找到循环序列
        if(toset.contains(start)) {
            if(depth>2) lists.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        //没找到，继续向下遍历
        Iterator iterator = toset.iterator();
        while (iterator.hasNext()){
            Node node = (Node) iterator.next();
            path(lists,list,node,start,depth+1);
        }

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
