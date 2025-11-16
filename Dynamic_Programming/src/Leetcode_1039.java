public class Leetcode_1039 {
    public static void main(String[] args) {
        Leetcode_1039 app = new Leetcode_1039();
        int[] values = {3,7,4,5};
        System.out.println("minimum polygon score : "+app.minScoreTriangulation(values));
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;    memLastBalloonCoin = new int[n][n];
        return explorePolygons(0,n-1,values);
    }
    int[][] memLastBalloonCoin; int n; // Time O(n^3)
    private int explorePolygons(int start, int end, int[] values){
        if (end-start+1<3) return 0;// less than 3 points
        if (memLastBalloonCoin[start][end]!=0) return memLastBalloonCoin[start][end];

        int minPolygonScore=Integer.MAX_VALUE;
        for (int middle = start+1; middle < end; middle++) {
            int polygonScore =  values[start]*values[middle]*values[end]
                    + explorePolygons(start,middle,values)
                    + explorePolygons(middle,end,values);
            minPolygonScore = Math.min(minPolygonScore,polygonScore);
        }

        return memLastBalloonCoin[start][end] = minPolygonScore;
    }
}