package Bellman_Ford;


import java.util.Arrays;

public class Leetcode_787 {
    public static void main(String[] args) {
        Leetcode_787 app = new Leetcode_787();
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}; int n=4,src = 0, dst=3 , k=1;
        System.out.println("cheapest flight within K stops costs : " + app.findCheapestPrice(n,flights,src,dst,k));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] nodeReachCost = new int[n];
        Arrays.fill(nodeReachCost, Integer.MAX_VALUE);
        nodeReachCost[src] = 0;

        for (int i = 0; i < k+1; i++) { //bellman ford in BFS style, relax edges only if u node has been reached.
            int[] neighborExploreCost = Arrays.copyOf(nodeReachCost, n);
            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];
                if (nodeReachCost[u] != Integer.MAX_VALUE && nodeReachCost[u] + cost < neighborExploreCost[v]) // if the node has been reached previously
                    neighborExploreCost[v] = nodeReachCost[u] + cost;

            }
            nodeReachCost = neighborExploreCost;
        }
        return nodeReachCost[dst] != Integer.MAX_VALUE ? nodeReachCost[dst] : -1;
    }

}