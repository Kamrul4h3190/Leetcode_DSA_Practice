package Dijkstra;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_787 {
    public static void main(String[] args) {
        Leetcode_787 app = new Leetcode_787();
//        int[][]flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};int src = 0, dst = 2, k = 2, n = 5;
//        int[][]flights = {{0,1,100},{0,2,300},{0,3,500},{1,2,100},{2,3,100}};int src = 0, dst = 3, k = 1, n = 4;
//        int[][]flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};int src = 0, dst = 3, k = 1, n = 4;
        int[][]flights = {{0,1,100},{1,2,100},{0,2,500}};int src = 0, dst = 2, k = 0, n = 3;
//        int[][]flights = {{0,1,100},{1,2,100},{0,2,500}};int src = 0, dst = 2, k = 1, n = 3;
//        int[][]flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};int src = 0, dst = 3, k = 1, n = 4;
        System.out.println("network minimum coverage time : " + app.findCheapestPrice(n,flights,src,dst,k));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : flights) {
            int u = edge[0] , v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});//u->(v,w)
        }

        int[][] dist = new int[n][1+k+2];//making k 1 based ,At least 1 node is required
        for (int[] d: dist) Arrays.fill(d,Integer.MAX_VALUE);
        dist[src][1]=0;//reached src, 1 stops : cost 0
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);//sorted on weight
        queue.offer(new int[]{src,0,1});//(src,dist,k)
        while (!queue.isEmpty()){
            int[] uNode = queue.poll();
            int u = uNode[0],du = uNode[1],ku = uNode[2];
            if (u==dst) return du;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];    int dv = du+neighbor[1];
                int kv = ku+1;//precalculate required stops
                if (kv-2>k) continue;//if kv exceeds k skip this path
                if (dv<dist[v][kv]){
                    dist[v][kv] = dv;
                    queue.offer(new int[]{v,dv,kv});
                }
            }
        }
        return -1;
    }
}