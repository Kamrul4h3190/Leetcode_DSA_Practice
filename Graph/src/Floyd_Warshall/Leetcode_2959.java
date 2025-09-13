package Floyd_Warshall;


import java.util.Arrays;

public class Leetcode_2959 {
    public static void main(String[] args) {
        Leetcode_2959 app = new Leetcode_2959();
        int n = 3, maxDistance = 5;int[][] roads = {{0,1,2},{1,2,10},{0,2,10}};
        System.out.println("ways of closing branches : " + app.numberOfSets(n,maxDistance,roads));
    }
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ways = 0;
        for (int set = 0; set < (1<<n); set++) { //<< = 2 power n. explore all subsets
            int[][] costMatrix = new int[n][n];
            for (int i = 0; i < n; i++) {//initiate graph with infinite cost ,except diagonals
                for (int j = 0; j < n; j++) {
                    if (i!=j) costMatrix[i][j] = (int) (1e9+7);
                }
            }

            for (int[] edge : roads) { // initial cost fills .
                int u = edge[0],v=edge[1],c=edge[2];
                if ( ((set>>u & 1) ==1) && (set>>v & 1)==1 ){ //both u and v stays in set
                    costMatrix[u][v] = Math.min( costMatrix[u][v] , c ); //for duplicates keep min
                    costMatrix[v][u] = Math.min( costMatrix[v][u] , c );
                }
            }

            floydWarshall(n,costMatrix); //minimize distances

            boolean setOk = true; //checking valid sets(branches)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ( ((set>>i & 1) ==1) && (set>>j & 1)==1 ){
                        if (costMatrix[i][j] > maxDistance){
                            setOk = false;
                            break;
                        }
                    }
                }
            }
            if (setOk) ways++;
        }
        return ways;
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