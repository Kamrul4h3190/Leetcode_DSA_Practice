import java.util.*;

public class Leetcode_3148 {
    public static void main(String[] args) {
        Leetcode_3148 app = new Leetcode_3148();
//        Integer[][] gridValues = { {4,3,2},{3,2,1} };
        Integer[][] gridValues = { {9,5,7,3},{8,9,6,1},{6,7,14,3},{2,5,3,1} };
        List<List<Integer>> grid = new ArrayList<>();
        for (Integer[] row : gridValues) //must use Integer wraper class in valuesGrid
            grid.add(new ArrayList<>(List.of(row)));

        System.out.println("maximum difference score : "+app.maxScore(grid));
    }

    public int maxScore(List<List<Integer>> grid) {
        m = grid.size();n = grid.get(0).size();maxNegative = (int)(-1e9);
        memDiff = new Integer[m][n];
        int maxDiff = maxNegative;
        //Calling from every cell
//        for(int i =0 ; i < m ; i++){
//            for(int j =0 ; j < n ; j++){
//                maxDiff= Math.max(helper(i,j,grid),maxDiff);
//            }
//        }
        explore(0,0,grid);//call once, after the call check the memArray
        for(int i =0 ; i < m ; i++){
            for(int j =0 ; j < n ; j++){
                if(memDiff[i][j]!=null) maxDiff= Math.max(memDiff[i][j],maxDiff);
            }
        }
        return maxDiff;
    }
    int m,n,maxNegative;    Integer[][] memDiff;
    int explore(int i , int j, List<List<Integer>> grid){
        if(i==m-1 && j==n-1)return maxNegative;
        if(memDiff[i][j]!=null) return memDiff[i][j];

        int right = maxNegative,down =maxNegative;
        if(j<n-1) right = (grid.get(i).get(j+1) - grid.get(i).get(j)) + Math.max(0, explore(i,j+1,grid));//check right column(j)+1
        if(i<m-1) down = (grid.get(i+1).get(j) - grid.get(i).get(j)) + Math.max(0, explore(i+1,j,grid));//check down row(i)+1

        return memDiff[i][j]=Math.max(right ,down);
    }
}