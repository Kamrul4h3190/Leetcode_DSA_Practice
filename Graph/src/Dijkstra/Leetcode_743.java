package Dijkstra;


import java.util.*;

public class Leetcode_743 {
    public static void main(String[] args) {
        Leetcode_743 app = new Leetcode_743();
        int[][] time = {{2,1,1}, {2,3, 1}, {3,4,1}}; int n = 4; int k = 2;
        System.out.println("network minimum coverage time : " + app.networkDelayTime(time,n,k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] time : times) {
            int u = time[0] - 1, v = time[1] - 1, w = time[2]; //1 based nodes
            adjList.get(u).add(new int[]{v, w});
        }
        int[] minTimes = dijkstra(k-1,n,adjList);
        int minCoverageTime = Integer.MIN_VALUE;
        for (int minTime : minTimes) minCoverageTime = Math.max(minCoverageTime, minTime);
        return minCoverageTime == Integer.MAX_VALUE ? -1 : minCoverageTime;
    }
    private int[] dijkstra(int src,int n,List<List<int[]>> adjList){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]); //min heap based on W's
        int[] minTimes = new int[n];    Arrays.fill(minTimes,Integer.MAX_VALUE);
        minTimes[src]=0;    queue.offer(new int[]{src,0});
        while (!queue.isEmpty()){
            int u = queue.poll()[0];
            for (int[] neighbor : adjList.get(u)) {
                int v = neighbor[0];    int w = neighbor[1];//w=cost
                if (minTimes[u]+w < minTimes[v]){// if cost is less via this path, update
                    minTimes[v] = minTimes[u]+w;
                    queue.offer(new int[]{v,minTimes[v]});
                }
            }
        }
        return minTimes;
    }
}