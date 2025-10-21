import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_37 {
    public static void main(String[] args) {
        Leetcode_37 app = new Leetcode_37();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        app.solveSudoku(board);
        System.out.println("Sudoku solved \n"+ Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue; //digit given in sudoku no need to solve

                for (char digit = '1'; digit<='9'; digit++){//try to place digits safely
                    if (digitSafe(i,j,digit,board)){
                        board[i][j] = digit;
                        if (solve(board)) return true;
                        board[i][j] = '.'; //if not safely placed backtrack, and explore next digit
                    }
                }
                return false; //no digits placed safely
            }
        }
        return true; // no '.' found ,all sudoku already solved
    }

    private boolean digitSafe(int x,int y, int digit,char[][] board){
        for (int i = 0; i < 9; i++) {
            if (board[i][y] == digit) return false;// col fixed, check repeat in row
            if (board[x][i] == digit) return false;// row fixed, check repeat in col
        }

        int subGridStartX = (x/3) * 3;    int subGridStartY = (y/3) * 3; //check repeat in subgrids
        int subGridEndX= subGridStartX + 3,subGridEndY= subGridStartY +3;
        for (int i = subGridStartX; i < subGridEndX; i++) {
            for (int j = subGridStartY; j < subGridEndY; j++) {
                if (board[i][j] == digit) return false;
            }
        }
        return true;
    }
}

