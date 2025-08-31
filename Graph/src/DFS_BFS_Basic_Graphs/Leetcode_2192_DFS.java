package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.List;

public class Leetcode_2192_DFS {
    public static void main(String[] args) {
        Leetcode_2192_DFS app = new Leetcode_2192_DFS();
//        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        int[][] edgeList = {{7,5,},{2,5},{0,7},{0,1},{6,1},{2,4},{3,5}}; int n = 9;
//        int[][] edgeList = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}; int n = 8;
        System.out.println("ancestors : "+ app.getAncestors(n,edgeList));
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(edges,n);
        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) ancestors.add(new ArrayList<>());
        for (int i = 0; i < n; i++)
            dfs(i,i,graph,new boolean[n],ancestors);
        return ancestors;
    }
    private void dfs(int u,int parent,List<List<Integer>> graph,boolean[] visited,List<List<Integer>> ancestors){
        if (visited[u]) return;
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) ancestors.get(v).add(parent);//put parent as ancestor of all V's
            dfs(v,parent,graph,visited,ancestors);
        }
    }
    private List<List<Integer>> buildGraph(int[][] edges,int n){
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>()); //there may be less edges than n
        for (int[] edge : edges) {
            int u = edge[0],v=edge[1];
            adjList.get(u).add(v);
        }
        return adjList;
    }
}