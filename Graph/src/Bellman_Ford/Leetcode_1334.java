package Bellman_Ford;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_1334 {
    public static void main(String[] args) {
        Leetcode_1334 app = new Leetcode_1334();
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}}; int n=5,distanceThreshold = 2;
//        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}}; int n=4,distanceThreshold = 4;
        System.out.println("less dense city : " + app.findTheCity(n,edges,distanceThreshold));
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] costMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(costMatrix[i],Integer.MAX_VALUE);
            costMatrix[i][i] = 0;//self distance
        }

        for (int source = 0; source < n; source++)
            bellman(source,n,costMatrix[source],edges);

        return lessDensedCity(costMatrix,distanceThreshold,n);
    }

    private void bellman(int source,int n,int[] costRow,int[][] edges){
        for (int i = 0; i < n - 1; i++) {//relax edges v-1 times
            for (int[] edge:edges){
                int u = edge[0],v = edge[1],cost = edge[2];

                if (costRow[u]!=Integer.MAX_VALUE && costRow[u] + cost < costRow[v]) costRow[v] = costRow[u] + cost;//bidirectional edge relax
                if (costRow[v]!=Integer.MAX_VALUE && costRow[v] + cost < costRow[u]) costRow[u] = costRow[v] + cost;
            }
        }
    }

    private int lessDensedCity(int[][] costMatrix,int threshold,int n){
        int minDensedCity = -1; int minNeighbor = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int neighbor = 0;
            for (int d : costMatrix[i]) if (d<=threshold) neighbor++;

            if (neighbor<=minNeighbor){
                minNeighbor = neighbor;
                minDensedCity = i;
            }
        }
        return minDensedCity;
    }

}