package Dijkstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_2045 {
    public static void main(String[] args) {
        Leetcode_2045 app = new Leetcode_2045();
        int[][] edges = {{1,2},{1,3},{1,4},{3,4},{4,5}}; int n=5,time = 3,change = 5;
        System.out.println("second minimum distance : " + app.secondMinimum(n,edges,time,change));
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());//1 based nodes;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adjList.get(u).add(v);  adjList.get(v).add(u);
        }

        int[] dist1 = new int[n+1],dist2 = new int[n+1];//1 based
        Arrays.fill(dist1,Integer.MAX_VALUE);   Arrays.fill(dist2,Integer.MAX_VALUE);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        dist1[1] = 0; queue.offer(new int[]{0,1});//pair(distance,ndoe)
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int u = node[1];    int timePassed = node[0];

            if (u == n && dist2[n] != Integer.MAX_VALUE) return dist2[n];

            int div = timePassed / change;
            if (div % 2 == 1) timePassed = change * (div + 1); //if div odd(RED),wait required so increase time to next div


            for (int v : adjList.get(u)) {
                if (timePassed + time< dist1[v]) {
                    dist2[v] = dist1[v];
                    dist1[v] = timePassed + time;//send dist1 to dist2
                    queue.offer(new int[]{dist1[v], v});//update dist1
                } else if (timePassed + time < dist2[v] && dist1[v] != timePassed + time) {
                    dist2[v] = timePassed + time;
                    queue.offer(new int[]{dist2[v], v});
                }
            }
        }
        return -1;//just syntactical return
    }
}