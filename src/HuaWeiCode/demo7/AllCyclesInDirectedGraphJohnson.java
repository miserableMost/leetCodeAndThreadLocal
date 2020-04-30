package HuaWeiCode.demo7;

import java.util.*;

/**
 * Date 11/16/2015
 * @author Tushar Roy
 *
 * Find all cycles in directed graph using Johnson's algorithm
 *
 * Time complexity - O(E + V).(c+1) where c is number of cycles found
 * Space complexity - O(E + V + s) where s is sum of length of all cycles.
 *
 * Link to youtube video - https://youtu.be/johyrWospv0
 *
 * References
 * https://github.com/jgrapht/jgrapht/blob/master/jgrapht-core/src/main/java/org/jgrapht/alg/cycle/JohnsonSimpleCycles.java
 */
public class AllCyclesInDirectedGraphJohnson {
    Set<Vertex<Integer>> blockedSet;
    Map<Vertex<Integer>, Set<Vertex<Integer>>> blockedMap;
    Deque<Vertex<Integer>> stack;
    List<List<Vertex<Integer>>> allCycles;

    /**
     * sort.Main function to find all cycles
     */
    public List<List<Vertex<Integer>>> simpleCyles(Graph<Integer> graph) {

        blockedSet = new HashSet<>();
        blockedMap = new HashMap<>();
        stack = new LinkedList<>();
        allCycles = new ArrayList<>();
        long startIndex = 1;
        TarjanStronglyConnectedComponent tarjan = new TarjanStronglyConnectedComponent();
        while(startIndex <= graph.getAllVertex().size()) {
            Graph<Integer> subGraph = createSubGraph(startIndex, graph);
            List<Set<Vertex<Integer>>> sccs = tarjan.scc(subGraph);
            //this creates graph consisting of strongly connected components only and then returns the
            //least indexed vertex among all the strongly connected component graph.
            //it also ignore one vertex graph since it wont have any cycle.
            //这将创建仅由强连接组件组成的图，然后返回
            //
            //所有强连通分量图中的最小索引顶点。由于没有任何圈，它也忽略了一个顶点图。
            Optional<Vertex<Integer>> maybeLeastVertex = leastIndexSCC(sccs, subGraph);
            if(maybeLeastVertex.isPresent()) {
                Vertex<Integer> leastVertex = maybeLeastVertex.get();
                blockedSet.clear();
                blockedMap.clear();
                findCyclesInSCG(leastVertex, leastVertex,1);
                startIndex = leastVertex.getId() + 1;
            } else {
                break;
            }
        }
        return allCycles;
    }

    private Optional<Vertex<Integer>> leastIndexSCC(List<Set<Vertex<Integer>>> sccs, Graph<Integer> subGraph) {
        long min = Integer.MAX_VALUE;
        Vertex<Integer> minVertex = null;
        Set<Vertex<Integer>> minScc = null;
        for(Set<Vertex<Integer>> scc : sccs) {
            if(scc.size() == 1) {
                continue;
            }
            for(Vertex<Integer> vertex : scc) {
                if(vertex.getId() < min) {
                    min = vertex.getId();
                    minVertex = vertex;
                    minScc = scc;
                }
            }
        }

        if(minVertex == null) {
            return Optional.empty();
        }
        Graph<Integer> graphScc = new Graph<>(true);
        for(Edge<Integer> edge : subGraph.getAllEdges()) {
            if(minScc.contains(edge.getVertex1()) && minScc.contains(edge.getVertex2())) {
                graphScc.addEdge(edge.getVertex1().getId(), edge.getVertex2().getId());
            }
        }
        return Optional.of(graphScc.getVertex(minVertex.getId()));
    }

    private void unblock(Vertex<Integer> u) {
        blockedSet.remove(u);
        if(blockedMap.get(u) != null) {
            blockedMap.get(u).forEach( v -> {
                if(blockedSet.contains(v)) {
                    unblock(v);
                }
            });
            blockedMap.remove(u);
        }
    }

    private boolean findCyclesInSCG(
            Vertex<Integer> startVertex,
            Vertex<Integer> currentVertex,int depth) {
        if(depth > 7)
            return false;
        boolean foundCycle = false;
        stack.push(currentVertex);
        blockedSet.add(currentVertex);

        for (Edge<Integer> e : currentVertex.getEdges()) {
            Vertex<Integer> neighbor = e.getVertex2();
            //if neighbor is same as start vertex means cycle is found.
            // 如果“邻居”与“开始顶点”相同，则表示找到循环。
            //Store contents of stack in final result.
            //将堆栈内容存储在最终结果中。
            if (neighbor == startVertex) {
                if(depth > 2) {
                    List<Vertex<Integer>> cycle = new ArrayList<>();
                    //stack.push(startVertex);
                    cycle.addAll(stack);
                    Collections.reverse(cycle);
                    //stack.pop();
                    allCycles.add(cycle);
                }
                foundCycle = true;
            } //explore this neighbor only if it is not in blockedSet. 仅当此邻居不在blockedSet中时才对其进行探索。
            else if (!blockedSet.contains(neighbor)) {
                boolean gotCycle =
                        findCyclesInSCG(startVertex, neighbor,depth + 1);
                foundCycle = foundCycle || gotCycle;
            }
        }
        //if cycle is found with current vertex then recursively unblock vertex and all vertices which are dependent on this vertex.
        //如果找到当前顶点的循环，则递归取消阻止该顶点和依赖于该顶点的所有顶点。
        if (foundCycle) {
            //remove from blockedSet  and then remove all the other vertices dependent on this vertex from blockedSet
            //从blockedSet移除，然后从blockedSet移除依赖于此顶点的所有其他顶点
            unblock(currentVertex);
        } else {
            //if no cycle is found with current vertex then don't unblock it. But find all its neighbors and add this
            //如果没有找到当前顶点的循环，则不要取消阻止它。但是找到它所有的邻居并加上这个
            //vertex to their blockedMap. If any of those neighbors ever get unblocked then unblock current vertex as well.
            //他们被封锁的地图的顶点。如果这些邻居中的任何一个被解除阻止，那么也解除阻止当前顶点。
            for (Edge<Integer> e : currentVertex.getEdges()) {
                Vertex<Integer> w = e.getVertex2();
                Set<Vertex<Integer>> bSet = getBSet(w);
                bSet.add(currentVertex);
            }
        }
        //remove vertex from the stack.
        //从堆栈中移除顶点。
        stack.pop();
        return foundCycle;
    }

    private Set<Vertex<Integer>> getBSet(Vertex<Integer> v) {
        return blockedMap.computeIfAbsent(v, (key) ->
                new HashSet<>() );
    }

    private Graph createSubGraph(long startVertex, Graph<Integer> graph) {
        Graph<Integer> subGraph = new Graph<>(true);
        for(Edge<Integer> edge : graph.getAllEdges()) {
            if(edge.getVertex1().getId() >= startVertex && edge.getVertex2().getId() >= startVertex) {
                subGraph.addEdge(edge.getVertex1().getId(), edge.getVertex2().getId());
            }
        }
        return subGraph;
    }

    public static void main(String args[]) {
        AllCyclesInDirectedGraphJohnson johnson = new AllCyclesInDirectedGraphJohnson();
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 8);
        graph.addEdge(1, 5);
        graph.addEdge(2, 9);
        graph.addEdge(2, 7);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 6);
        graph.addEdge(3, 4);
        graph.addEdge(6, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);
        graph.addEdge(8, 9);
        graph.addEdge(9, 8);

        List<List<Vertex<Integer>>> allCycles = johnson.simpleCyles(graph);
        allCycles.forEach(cycle -> {
            StringJoiner joiner = new StringJoiner("->");
            cycle.forEach(vertex -> joiner.add(String.valueOf(vertex.getId())));
            System.out.println(joiner);
        });
    }

}
