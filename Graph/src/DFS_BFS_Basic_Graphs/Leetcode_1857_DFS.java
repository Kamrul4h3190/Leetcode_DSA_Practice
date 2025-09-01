package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.List;

public class Leetcode_1857_DFS {
    public static void main(String[] args) {
        Leetcode_1857_DFS app = new Leetcode_1857_DFS();
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}}; String colors = "abaca";
        System.out.println("max same color path : "+ app.largestPathValue(colors,edges));
    }
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();    List<List<Integer>> graph = new ArrayList<>();//build graph
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) graph.get(edge[0]).add(edge[1]);//u->v

        int maxColorLength = 0;
        int[] visited = new int[n];     int[][] memColor = new int[n][26];
        for (int i = 0; i < n; i++) {
            int colorLength = dfs(i,graph,visited,memColor,colors);
            if (colorLength==Integer.MAX_VALUE) return -1;//cycle found
            maxColorLength = Math.max(colorLength,maxColorLength);
        }
        return maxColorLength;
    }
    private int dfs(int u,List<List<Integer>> graph,int[] visited,int[][] memColor,String colors){
        if (visited[u]==1) return Integer.MAX_VALUE;//cycle
        if (visited[u]==0){ //not visited yet
            visited[u] = 1;//visiting current dfs, detects cycle
            for (int v : graph.get(u)){
                if( dfs(v, graph, visited, memColor, colors)==Integer.MAX_VALUE ) return Integer.MAX_VALUE;

                for (int col = 0; col < 26; col++)//maximize 26 columns of U with V
                    memColor[u][col] = Math.max(memColor[u][col],memColor[v][col]);
            }
            memColor[u][colors.charAt(u)-'a']++; //increase u's color count;
            visited[u] = 2;
        }
        return memColor[u][colors.charAt(u)-'a'];//also works for color 2(already explored nodes)
    }

}