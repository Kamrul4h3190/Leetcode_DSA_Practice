package Floyd_Warshall;


import java.util.Arrays;

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
            Arrays.fill(costMatrix[i], (int) 1e9 + 7);//overflow handle
            costMatrix[i][i] = 0;  // Distance to itself is zero
        }

        for (int[] edge : edges) {//fill primary weights
            int u = edge[0];int v = edge[1];int cost = edge[2];
            costMatrix[u][v] = cost;    costMatrix[v][u] = cost;
        }

        floydWarshall(n, costMatrix);

        return getCityWithFewestReachable(n, costMatrix, distanceThreshold);
    }
    void floydWarshall(int n, int[][] costMatrix) {
        for (int i = 0; i < n; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    costMatrix[u][v] = Math.min(costMatrix[u][v], costMatrix[u][i] + costMatrix[i][v]);
                }
            }
        }
    }

    int getCityWithFewestReachable(int n, int[][] costMatrix, int threshold) {
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