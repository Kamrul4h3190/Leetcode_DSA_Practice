package Dijkstra;


import java.util.*;

public class Leetcode_1976 {
    public static void main(String[] args) {
        Leetcode_1976 app = new Leetcode_1976();
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}; int n = 7;
        System.out.println("network minimum coverage roads : " + app.countPaths(n,roads));
    }

    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] road : roads) {
            int u = road[0], v = road[1] , t = road[2];
            adjList.get(u).add(new int[]{v, t});
            adjList.get(v).add(new int[]{u, t});
        }
        int[] minPathWays = dijkstra(0,n,adjList);
        return minPathWays[n-1];
    }
    private int[] dijkstra(int src,int n,List<List<int[]>> adjList){
        PriorityQueue<long[]> queue = new PriorityQueue<>((a,b)-> Math.toIntExact(a[1] - b[1])); //min heap based on W's
        long[] distance = new long[n];  Arrays.fill(distance,Long.MAX_VALUE);
        int[] minWays = new int[n];

        distance[src]=0;    minWays[0]=1;
        queue.offer(new long[]{src,0});      int MOD = 1_000_000_007;
        while (!queue.isEmpty()){
            long[] curr = queue.poll();
            int u = (int) curr[0];
            long tu = curr[1];

            if (tu>distance[u]) continue;//relaxed better ,skip this

            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0];    int w = neighbor[1];//w=cost
                if (distance[u]+w < distance[v]){// if cost is less via this path, update
                    distance[v] = distance[u]+w;
                    minWays[v] = minWays[u];
                    queue.offer(new long[]{v,distance[v]});
                } else if (distance[u]+w == distance[v]) {
                    minWays[v] = (minWays[v]+minWays[u])%MOD;
                }
            }
        }
        return minWays;
    }
}