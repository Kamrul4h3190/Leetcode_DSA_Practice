package DFS_BFS_Basic_Graphs;


public class Leetcode_1905_DFS {
    public static void main(String[] args) {
        Leetcode_1905_DFS app = new Leetcode_1905_DFS();
//        int[][] grid1 = {{0,0},{0,1}}, grid2 = {{1,1},{0,1}};
        int[][] grid1 = {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}}, grid2 = {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};
        System.out.println("sub islands : "+ app.countSubIslands(grid1,grid2));
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length; n = grid1[0].length;   visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j]==1 && !visited[i][j]){
                    dfs(i,j,grid1,grid2);
                    if (subIsland) subIslands++;

                    subIsland = true;//reset for next call
                }
            }
        }
        return subIslands;
    }
    int subIslands = 0;     boolean subIsland = true;
    int m,n; boolean[][] visited;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    private void dfs(int i,int j,int[][] grid1,int[][] grid2){
        if (i<0 || i>=m || j<0 || j>=n || grid2[i][j]==0) return;//range out
        if (visited[i][j]) return;

        visited[i][j] = true;
        subIsland = subIsland && grid1[i][j] == 1; //if grid1[i][j]!1 set false and && with flag . But do not stop, Keep doing the DFS ,finish visiting the current island.
        for (int[] dir:directions) {
            int x = i + dir[0],y = j + dir[1];
            dfs(x, y, grid1,grid2);
        }
    }

}