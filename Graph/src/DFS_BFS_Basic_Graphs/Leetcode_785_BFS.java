package DFS_BFS_Basic_Graphs;


import java.util.*;

public class Leetcode_785_BFS {
    public static void main(String[] args) {
        Leetcode_785_BFS app = new Leetcode_785_BFS();
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println("graph bipartite : " + app.isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;   int[] colors = new int[n];
        for (int i = 0; i < n; i++) {//bfs each node and color them
            if (colors[i]==0){//if not colored
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);     colors[i] = 1;

                while (!queue.isEmpty()){
                    int u = queue.poll();
                    for (int v : graph[u]) {
                        if (colors[v]==colors[u]) return false;//same color adjacents. not bipartite
                        if (colors[v]==0){ //not colored yet. color different and push in queue
                            colors[v] = -colors[u];
                            queue.offer(v);
                        }
                    }
                }
            }
        }
        return true;
    }
}