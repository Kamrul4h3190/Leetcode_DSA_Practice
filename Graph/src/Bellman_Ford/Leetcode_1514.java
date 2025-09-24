package Bellman_Ford;


import java.util.Arrays;

public class Leetcode_1514 {
    public static void main(String[] args) {
        Leetcode_1514 app = new Leetcode_1514();
        int[][] edges = {{0,1},{1,2},{0,2}};double[] succProb = {0.5,0.5,0.2};int start = 0, end = 2,n = 3;
        System.out.println("max path probability : " + app.maxProbability(n,  edges, succProb,  start,  end));
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);
        dist[start_node] = 1.0;

        for (int i = 0; i < n - 1; i++) { //maximize bellman ford
            boolean updated = false;
            for (int e = 0; e < edges.length; e++) {
                int u = edges[e][0],v = edges[e][1];    double p = succProb[e];

                if (dist[u]*p > dist[v]){dist[v] = dist[u]*p;   updated = true;}//bidirectional edge relax
                if (dist[v]*p > dist[u]){dist[u] = dist[v]*p;   updated = true;}
            }
            if (!updated) break; //early stop, optional
        }

        return dist[end_node];
    }
}