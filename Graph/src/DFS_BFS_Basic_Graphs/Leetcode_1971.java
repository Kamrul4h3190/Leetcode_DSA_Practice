package DFS_BFS_Basic_Graphs;


import java.util.*;

public class Leetcode_1971 {
    public static void main(String[] args) {
        Leetcode_1971 app = new Leetcode_1971();
        int[][] edges = {{0,1}, {1,2}, {2,0}}; int n=3,source=0,destination=2;
        System.out.println("path exists : "+ app.validPath(n,edges,source,destination));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new HashMap<>();    visited = new HashSet<>();
        for (int[] edge : edges) {//build the graph(adj list)
            graph.putIfAbsent(edge[0],new ArrayList<>());
            graph.putIfAbsent(edge[1],new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return pathExists(source,destination,graph);
    }
    Map<Integer, List<Integer>> graph;  Set<Integer> visited;
    private boolean pathExists(int src,int dest,Map<Integer,List<Integer>> graph){
        if (src==dest) return true;

        visited.add(src);//mark the curr node visited and dfs all unvisited neighbors
        for (int neighbor: graph.get(src)){
            if (!visited.contains(neighbor))
                if(pathExists(neighbor,dest,graph))
                    return true;
        }
        return false;
    }
}