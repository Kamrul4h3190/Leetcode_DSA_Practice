package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.List;

public class Leetcode_547_DFS {
    public static void main(String[] args) {
        Leetcode_547_DFS app = new Leetcode_547_DFS();
        int[][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println("number of province : "+app.findCircleNum(isConnected));
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i <n ; i++) {//build graph adjacency list
            graph.add(new ArrayList<>());//new list for each node
            for (int j = 0; j < n; j++) {
                if (i!=j && isConnected[i][j]==1){//push neighbor to the respective node
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[graph.size()];
        int provinces = 0;
        for (int i=0 ; i<n ; i++) {//check connectedness for each node.
            if (!visited[i]) {
                dfs(i,graph,visited);//dfs done. connection terminates. province++
                provinces++;
            }
        }
        return provinces;
    }
    private void dfs(int source,List<List<Integer>> graph,boolean[] visited){
        visited[source] = true;
        for (int neighbor: graph.get(source)) {
            if (!visited[neighbor])
                dfs(neighbor, graph, visited);
        }
    }
}