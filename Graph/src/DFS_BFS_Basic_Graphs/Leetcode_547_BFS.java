package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_547_BFS {
    public static void main(String[] args) {
        Leetcode_547_BFS app = new Leetcode_547_BFS();
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
                bfs(i,graph,visited);//bfs done. connection terminates. province++
                provinces++;
            }
        }
        return provinces;
    }
    private void bfs(int source, List<List<Integer>> graph, boolean[] visited){
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()){
            int curr = queue.poll();
            for (int neighbor: graph.get(curr)) {
                if (!visited[neighbor])
                    bfs(neighbor, graph, visited);
            }
        }
    }
}