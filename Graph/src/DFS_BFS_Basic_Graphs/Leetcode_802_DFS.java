package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.List;

public class Leetcode_802_DFS {
    public static void main(String[] args) {
        Leetcode_802_DFS app = new Leetcode_802_DFS();
//        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println("safe states : "+ app.eventualSafeNodes(graph));
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> serial = new ArrayList<>();
        int[] color = new int[n];
        for (int u = 0; u<n ; u++)
            if(dfs(u,graph,color))   serial.add(u);

        return serial;
    }
    private boolean dfs(int u,int[][] graph,int[] color){
        if (color[u]==2) return true;//safe/terminal nodes
        if (color[u]==1) return false;//cycle
        color[u] = 1;//visiting current dfs, detects cycle

        for (int v : graph[u])
            if (!dfs(v, graph,color)) return false;

        color[u] = 2; //if not cycle happened during dfs, mark this terminal safe node

        return true;
    }

}