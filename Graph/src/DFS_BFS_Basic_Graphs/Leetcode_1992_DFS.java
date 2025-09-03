package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_1992_DFS {
    public static void main(String[] args) {
        Leetcode_1992_DFS app = new Leetcode_1992_DFS();
        int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
        System.out.println("farmlands : "+ Arrays.deepToString(app.findFarmland(land)));
    }
    public int[][] findFarmland(int[][] land) {
        List<int[]> farmlandsList = new ArrayList<>();
        m = land.length; n = land[0].length;   visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j]==1 && !visited[i][j]){
                    int[] ex={0};int[] ey={0};//pass by reference
                    dfs(i,j,ex,ey,land);
                    farmlandsList.add(new int[]{i, j,ex[0],ey[0]});
                }
            }
        }
        int[][] farmLands = new int[farmlandsList.size()][];
        int i = 0;  for (int[] coordinates : farmlandsList) farmLands[i++] = coordinates;
        return farmLands;
    }
    int m,n; boolean[][] visited;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    private void dfs(int i,int j,int[] ex,int[] ey,int[][] land){
        if (i<0 || i>=m || j<0 || j>=n || land[i][j]==0) return;//range out/forestland
        if (visited[i][j]) return;

        visited[i][j] = true;
        ex[0] = Math.max(i, ex[0]);   ey[0] = Math.max(j,ey[0]);//maximize ending x,y
        for (int[] dir:directions) {
            int x = i + dir[0],y = j + dir[1];
            dfs(x, y, ex, ey, land);
        }
    }

}