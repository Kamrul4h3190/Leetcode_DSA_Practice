package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_733_DFS {
    public static void main(String[] args) {
        Leetcode_733_DFS app = new Leetcode_733_DFS();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}}; int sr=1,sc=1,color=2;
        System.out.println("max same color path : "+ Arrays.deepToString(app.floodFill(image, sr, sc, color)));
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length,n = image[0].length;
        int startColor = image[sr][sc];
        dfs(sr,sc,color,startColor,m,n,image);
        return image;
    }
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    //no need visited array. color itself works as visited flag because for different color we skip dfs
    private void dfs(int sr,int sc,int color,int startColor,int  m,int n,int[][] image){
        if (sr<0 || sr>=m || sc<0 || sc>=n) return;//range out
        if (image[sr][sc]!=startColor) return;//different color
        if (image[sr][sc]==color) return;//cycle, already colored;

        image[sr][sc] = color;
        for (int[] dir:directions) {
            int x = sr + dir[0],y = sc + dir[1];
            dfs(x, y, color, startColor, m, n, image);
        }
    }

}