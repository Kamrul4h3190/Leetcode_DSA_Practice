package DFS_BFS_Basic_Graphs;


import java.util.Arrays;

public class Leetcode_200 {
    public static void main(String[] args) {
        Leetcode_200 app = new Leetcode_200();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("islands : "+ app.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        m = grid.length;    n = grid[0].length;
        visited = new int[m][n];
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1' && visited[i][j]==0){
                    dfs(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    int m,n;    int[][] visited;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    private void dfs(int i, int j,char[][] grid){
        if (i<0 || i>= m || j<0 || j>=n || grid[i][j]=='0' || visited[i][j]==1) return;

        visited[i][j] = 1;
        for (int[] direction : dirs) {
            int x = i+direction[0], y = j+direction[1];
            dfs(x,y,grid);
        }
    }
}