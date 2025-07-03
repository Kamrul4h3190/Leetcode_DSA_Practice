import java.util.Arrays;

public class Leetcode_712 {
    public static void main(String[] args) {
        Leetcode_712 app = new Leetcode_712();
        String s1 = "sea";
        String s2 = "eat";
        System.out.println("min ASCII delete sum : "+app.minimumDeleteSum(s1,s2));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        memDelete = new int[m][n];
        for (int[] row : memDelete) Arrays.fill(row,-1);

        return dynamicDelete(0,0,m,n,s1,s2);
    }
    int[][] memDelete;
    private int dynamicDelete(int i,int j,int m,int n,String s1,String s2){
        if(i>=m && j>=n) return 0;//base
        if (i>=m) return s2.charAt(j)+dynamicDelete(i, j+1, m, n, s1, s2);//s1 exhausted
        if (j>=n) return s1.charAt(i)+dynamicDelete(i+1, j, m, n, s1, s2);//s2 exhausted

        if (memDelete[i][j]!=-1) return memDelete[i][j];

        if (s1.charAt(i)==s2.charAt(j))
            return memDelete[i][j] = dynamicDelete(i+1, j+1, m, n, s1, s2);

        int delete_s1 = s1.charAt(i)+dynamicDelete(i+1, j, m, n, s1, s2);
        int delete_s2 = s2.charAt(j)+dynamicDelete(i, j+1, m, n, s1, s2);

        return memDelete[i][j] = Math.min(delete_s1,delete_s2);
    }
}