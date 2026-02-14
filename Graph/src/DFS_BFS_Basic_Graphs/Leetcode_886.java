package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode_886 {
    public static void main(String[] args) {
        Leetcode_886 app = new Leetcode_886();
        int n = 3;int[][] graph = {{1,2},{1,3},{2,3}};
//        int n = 4;int[][] graph = {{1,2},{1,3},{2,4}};
        System.out.println("can bipartite : " + app.possibleBipartition(n,graph));
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]-1).add(dislike[1]-1);
            graph.get(dislike[1]-1).add(dislike[0]-1);
        }
        return isBipartite(graph);
    }

    public boolean isBipartite(List<List<Integer>> graph) {
        int n = graph.size();   int[] colors = new int[n];
        for (int i = 0; i < n; i++) {//bfs each node and color them
            if (colors[i]==0){//if not colored
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);     colors[i] = 1;

                while (!queue.isEmpty()){
                    int u = queue.poll();
                    for (int v : graph.get(u)) {
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