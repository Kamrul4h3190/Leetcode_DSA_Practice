package DFS_BFS_Basic_Graphs;

import java.util.*;

public class Leetcode_2493 {
    public static void main(String[] args) {
        Leetcode_2493 app = new Leetcode_2493();
        int n = 6;int[][] edges = {{1,2},{1,4},{1,5},{2,6},{2,3},{4,6}};
        System.out.println("max bfs expansion : "+app.magnificentSets(n,edges));
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0]-1,v=edge[1]-1;//transform to 0 based nodes
            graph.get(u).add(v);    graph.get(v).add(u);
        }
        //bipartite detect and early stop
        int[] colors = new int[n];//bipart colors -1,+1
        for (int i = 0; i < n; i++) {
            if (colors[i]!=0) continue;
            colors[i] = 1;
            if (!bipartite(i,colors,graph)) return -1;
        }
        //explore bfs max expansions
        int[] distances = new int[n];
        for (int i = 0; i < n; i++)
            distances[i] = bfs(i,n,graph);

        //sum maxGroups for each connected components
        int maxGroups = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            maxGroups += componentMax(i,distances,visited,graph);
        }
        return maxGroups;
    }
    private int componentMax(int node,int[] distances,boolean[] visited,List<List<Integer>> graph){
        int maxExpansion = distances[node];
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (visited[neighbor]) continue;
            maxExpansion = Math.max(maxExpansion,
                    componentMax(neighbor,distances,visited,graph));
        }
        return maxExpansion;
    }
    private boolean bipartite(int node, int[] colors, List<List<Integer>> graph){
        for (int neighbor : graph.get(node)) {
            if (colors[node]==colors[neighbor]) return false;
            if (colors[neighbor]!=0) continue;

            colors[neighbor] = -1*colors[node];
            if (!bipartite(neighbor,colors,graph)) return false;
        }
        return true;
    }
    private int bfs(int node,int n,List<List<Integer>> graph){
        boolean[] visited = new boolean[n];//new visited array for each node
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);    visited[node] = true;
        int level = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int currNode = queue.poll();
                for (int neighbor : graph.get(currNode)) {
                    if (visited[neighbor]) continue;
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
            level++;
        }

        return level;
    }
}