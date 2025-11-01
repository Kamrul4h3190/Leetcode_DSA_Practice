import java.util.*;

public class Leetcode_1301 {
    public static void main(String[] args) {
        Leetcode_1301 app = new Leetcode_1301();
        String[] words = {"E12","1X1","21S"};
        List<String> board = new ArrayList<>(List.of(words));
        System.out.println("score,occurrence : "+ Arrays.toString(app.pathsWithMaxScore(board)));
    }
    public int[] pathsWithMaxScore(List<String> board) {
        memCells = new HashMap<>();
        int[] path_maxScore_occurrence = pathVisit(board.size()-1, board.size()-1,board);
        if (path_maxScore_occurrence[0]<0) return new int[]{0,0}; //max score negativeMax, no path found
        return path_maxScore_occurrence;
    }
    int mod = (int) 1e9+7;  Map<String,int[]> memCells; //i-j:[score,occurrence]
    private int[] pathVisit(int i,int j,List<String> board){
        if (i==0 && j==0) return new int[]{0,1};
        if (i<0 || j<0 || board.get(i).charAt(j)=='X') return new int[]{Integer.MIN_VALUE,0}; //[score,occurrences]. gridout/obstacle

        String key = i+"-"+j;   if (memCells.containsKey(key)) return memCells.get(key);

        int cellPoint = (board.get(i).charAt(j)=='S') ? 0 : board.get(i).charAt(j)-'0';
        int[] left = pathVisit(i, j-1, board);
        int[] upLeft = pathVisit(i-1,j-1,board);
        int[] up = pathVisit(i-1,j,board);
        int maxScore = Math.max(left[0],Math.max(upLeft[0],up[0]));

        int count = 0;//from wherever of 3 sides matches max score, count will increase to that sides count
        if (left[0]==maxScore) count += left[1];
        if (upLeft[0]==maxScore) count += upLeft[1];
        if (up[0]==maxScore) count += up[1];
        //memoize and return
        int[] score_occurrence = new int[]{(cellPoint+maxScore)%mod , count%mod};//score = currCellPoint + Max(3 directions)
        memCells.put(key,score_occurrence);     return score_occurrence;
    }
}