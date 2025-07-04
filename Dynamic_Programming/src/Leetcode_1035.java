import java.util.Arrays;

public class Leetcode_1035 {
    public static void main(String[] args) {
        Leetcode_1035 app = new Leetcode_1035();
        int[] nums1 = {1,3,7,1,7,5}, nums2 = {1,9,2,5,1};
//        int[] nums1 = {2,5,1,2,5}, nums2 = {10,5,2,1,5,2};
//        int[] nums1 = {1,4,2}, nums2 = {1,2,4};
        System.out.println("max uncrossed lines: "+app.maxUncrossedLines(nums1,nums2));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2= nums2.length;
        memMatches = new int[n1][n2];
        for (int[] row : memMatches) Arrays.fill(row,-1);

        return matchAndExpand(0,0,n1,n2,nums1,nums2);
    }
    int[][] memMatches;
    private int matchAndExpand(int i, int j,int n1,int n2, int[] nums1,int[] nums2){
        if(i>=n1 || j>=n2) return 0;

        if (memMatches[i][j]!=-1) return memMatches[i][j];

        if (nums1[i]==nums2[j])
            return memMatches[i][j] = 1 + matchAndExpand(i+1, j+1,n1,n2,nums1,nums2);

        int fix_i = matchAndExpand(i, j+1, n1, n2, nums1, nums2);
        int fix_j = matchAndExpand(i+1, j, n1, n2, nums1, nums2);

        return memMatches[i][j] = Math.max(fix_j,fix_i);
    }
}