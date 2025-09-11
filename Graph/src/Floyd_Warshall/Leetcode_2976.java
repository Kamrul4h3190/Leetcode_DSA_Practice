package Floyd_Warshall;


import java.util.Arrays;

public class Leetcode_2976 {
    public static void main(String[] args) {
        Leetcode_2976 app = new Leetcode_2976();
        String source = "abcd", target = "acbe";char[] original = {'a','b','c','c','e','d'}, changed = {'b','c','b','e','b','e'};int[] cost = {2,5,5,1,2,20};
        System.out.println("minimum transformation cost : " + app.minimumCost(source,target,original,changed,cost));
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;  int[][] costMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(costMatrix[i], (int) 1e9 + 7);//overflow handle
            costMatrix[i][i] = 0;  // Distance to itself is zero
        }

        for (int i = 0; i < cost.length; i++) {//update primary weights
            int u = original[i]-'a'; int v = changed[i]-'a';int c = cost[i];
            costMatrix[u][v] = Math.min(costMatrix[u][v] , c);//same edge may come with different costs, keep the minimum
        }

        floydWarshall(n, costMatrix);

        long minTransformCost = 0L;//find the transformation cost
        for (int i = 0; i < source.length(); i++) {
            int u = source.charAt(i)-'a'; int v = target.charAt(i)-'a';
            if (costMatrix[u][v]==(int) 1e9 + 7) return -1L;

            minTransformCost+=costMatrix[u][v];
        }
        return minTransformCost;
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
}