package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.List;

public class Leetcode_1446 {
    public static void main(String[] args) {
        Leetcode_1446 app = new Leetcode_1446();
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}}; int n = 6;
//        int[][] connections = {{1,0},{1,2},{3,2},{3,4}}; int n = 5;
        System.out.println("minimum reorders : "+app.minReorder(n,connections));
    }
    int reorders = 0;
    //flag setting: original edge 1,additional edge 0. DFS count number of original edges
    public int minReorder(int n, int[][] connections) {
        List<List<List<Integer>>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] pair : connections) {
            graph.get(pair[0]).add(new ArrayList<>(List.of(pair[1],1) ));
            graph.get(pair[1]).add(new ArrayList<>(List.of(pair[0],0) ));
        }
        boolean[] visited = new boolean[n];
        dfs(0,graph,visited);
        return reorders;
    }
    private void dfs(int source,List<List<List<Integer>>> graph,boolean[] visited){
        visited[source] = true;
        for (List<Integer> neighbor: graph.get(source)) {
            if (!visited[neighbor.get(0)]){
                dfs(neighbor.get(0), graph, visited);
                if (neighbor.get(1)==1) reorders++;
            }
        }
    }
//negative edge method
//    public int minReorder(int n, int[][] connections) {
//        List<List<Integer>> graph = new ArrayList<>();
//        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
//        for (int[] pair : connections) {
//            graph.get(pair[0]).add(pair[1]);
//            graph.get(pair[1]).add(-pair[0]);
//        }
//        boolean[] visited = new boolean[n];
//        dfs(0,graph,visited);
//        return reorders;
//    }
//    private void dfs(int source,List<List<Integer>> graph,boolean[] visited){
//        visited[source] = true;
//        for (int neighbor: graph.get(source)) {
//            if (!visited[Math.abs(neighbor)]){
//                dfs(Math.abs(neighbor) , graph, visited);
//                if(neighbor>=0)reorders++;
//            }
//        }
//    }
}