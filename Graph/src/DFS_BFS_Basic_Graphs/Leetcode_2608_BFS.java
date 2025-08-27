package DFS_BFS_Basic_Graphs;


import java.util.*;

public class Leetcode_2608_BFS {
    public static void main(String[] args) {
        Leetcode_2608_BFS app = new Leetcode_2608_BFS();
        int[][] edges = {{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}}; int n = 7;
        System.out.println("min length cycle : " + app.findShortestCycle(n,edges));
    }

    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];//make adjacency list
        for (int i = 0; i < n; i++) adjList[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0],v = edge[1];
            adjList[u].add(v);  adjList[v].add(u);
        }

        int minCycle = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {//bfs every edge and update min cycle
            int[] distance = new int[n];    Arrays.fill(distance,-1); //mark unvisited primarily
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);     distance[i] = 0;
            while (!queue.isEmpty()){
                int u = queue.poll();
                for (int v : adjList[u]) {
                    if (distance[v]==-1){//unvisited nodes
                        distance[v] = distance[u]+1;
                        queue.offer(v);
                    }else if (v != i && distance[v]>=distance[u]){//visited , non parent nodes,update minCycle
                        minCycle = Math.min(minCycle,distance[u]+distance[v]+1);
                    }
                }
            }
        }

        return minCycle==Integer.MAX_VALUE ? -1 : minCycle;
    }
}