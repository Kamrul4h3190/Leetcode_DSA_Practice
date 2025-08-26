package DFS_BFS_Basic_Graphs;


import java.util.*;

public class Leetcode_1559_BFS {
    public static void main(String[] args) {
        Leetcode_1559_BFS app = new Leetcode_1559_BFS();
        char[][] grid = {
                {'a', 'b', 'b'},
                {'b', 'z', 'b'},
                {'b', 'b', 'a'}};
        System.out.println("contain cycle : " + app.containsCycle(grid));
    }

    int m, n;   boolean[][] visited;
    public boolean containsCycle(char[][] grid) {
        m = grid.length;    n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {//bfs on every cell of grid
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && bfs(i,j,-1,-1,grid) )
                    return true;
            }
        }
        return false;
    }
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean bfs ( int i, int j, int parentX, int parentY, char[][] grid){
        char letter = grid[i][j];
        Queue<Cell> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.offer(new Cell(letter,i,j,parentX,parentY));
        while (!queue.isEmpty()){
            for (int k = 0,levelSize = queue.size(); k < levelSize; k++) {
                Cell currCell = queue.poll();
                for (int[] dir : directions) {
                    int newI = currCell.i+dir[0];
                    int newJ = currCell.j+dir[1];
                    if (newI<0 || newI>=m  || newJ<0 || newJ>=n ) continue; //range out
                    if (grid[newI][newJ]!=letter) continue; //different letter
                    if (newI == currCell.px && newJ == currCell.py) continue;//parent

                    if (visited[newI][newJ]) return true;

                    queue.offer(new Cell(letter,newI,newJ, currCell.i, currCell.j));
                    visited[newI][newJ] = true;
                }
            }
        }
        return false;
    }

    class Cell {
        char letter;
        int i,j,px,py;//co-ordinates,parents

        public Cell(char letter, int i, int j, int px, int py) {
            this.letter = letter;
            this.i = i;
            this.j = j;
            this.px = px;
            this.py = py;
        }
    }
}