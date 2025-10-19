import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_51 {
    public static void main(String[] args) {
        Leetcode_51 app = new Leetcode_51();
        int n=4;
        System.out.println("N queens board : "+ app.solveNQueens(n));
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];    // initiate the cheese board
        for (int i = 0; i < n; i++) Arrays.fill(board[i],'.');
        placeQueens(0,n,board,solutions);
        return solutions;
    }
    private void placeQueens(int row, int n, char[][] board, List<List<String>> solutions){
        if (row==n){ //safely placed all the queens, found a solution, Add this solution grid to solutions.
            List<String> solution = new ArrayList<>();
            for (char[] gridRow : board)    solution.add(new String(gridRow));

            solutions.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) { // for a particular row , try to place queens on all column cells
            if (attack(row,col,n,board)) continue; //this is an attack cell do not place queen here
            board[row][col] = 'Q';
            placeQueens(row+1,n,board,solutions);
            board[row][col] = '.';
        }
    }
    private boolean attack(int row, int col, int n, char[][] board) {
        for (int i = row-1; i >= 0; i--) //upward attack
            if (board[i][col]=='Q') return true;

        for (int i = row-1,j=col-1; i >=0 && j>=0 ; i--,j--)  //upper left diagonal attack
            if (board[i][j]=='Q') return true;

        for (int i = row-1,j=col+1; i >=0 && j<n ; i--,j++)  //upper right diagonal attack
            if (board[i][j]=='Q') return true;

        return false; //no attack
    }
}

