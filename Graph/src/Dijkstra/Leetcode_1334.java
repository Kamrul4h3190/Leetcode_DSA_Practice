package Dijkstra;


import java.util.*;

public class Leetcode_1334 {
    public static void main(String[] args) {
        Leetcode_1334 app = new Leetcode_1334();
        int[][]edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};int threshold = 4,n = 4;
//        int[][]edges = {{0,1,10},{0,2,1},{1,2,2}};int maxMoves = 6,n = 3;
        System.out.println("city with less neighbors : " + app.findTheCity(n,edges,threshold));
    }

    public int findTheCity(int n, int[][] edges, int threshold) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {//build undirected graph
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        int minNeighbor = n;    int city = -1;// O(N*(N+E)logN)
        for (int i = 0; i < n; i++) {//dijkstra form all nodes, and find less dense city within distance threshold
            int[] distances = dijkstra(i,graph,n);

            int cityCount = 0;
            for (int j = 0; j < n; j++)
                if (j!=i && distances[j]<=threshold)
                    cityCount++;
            if (cityCount<=minNeighbor){
                minNeighbor = cityCount;
                city = i;
            }
        }
        return city;
    }
    private int[] dijkstra(int source,List<List<int[]>> graph,int n){
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);//[node,distance]
        dist[source] = 0;   queue.offer(new int[]{source,0});
        while (!queue.isEmpty()){
            int[] uNode = queue.poll();
            int u = uNode[0],du = uNode[1];
            for (int[] vNode : graph.get(u)) {
                int v=vNode[0], dv=vNode[1];
                if (du+dv<dist[v]){
                    dist[v] = du+dv;
                    queue.offer(new int[]{v,dist[v]});
                }
            }
        }
        return dist;
    }
}