public class Leetcode_1351 {
    public static void main(String[] args) {
        Leetcode_1351 app = new Leetcode_1351();
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println("count negatives : "+ app.countNegatives(grid));
    }
    public int countNegatives(int[][] grid) {
        int m = grid.length;    int n = grid[0].length;
        int negatives=0;
        int row=0,col = n-1;
        while (row<m && col>=0){
            if (grid[row][col]>=0)
                row++;
            else {
                col--;
                negatives += m-row;
            }
        }
        return negatives;
    }
}