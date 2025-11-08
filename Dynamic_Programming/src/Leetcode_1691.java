import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode_1691 {
    public static void main(String[] args) {
        Leetcode_1691 app = new Leetcode_1691();
//        int[] group = {2,3,5},profit ={6,7,8};  int n=10,minProfit=5;
        int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}};
//        int[] nums = {4,15,3,32,64};
        System.out.println("maximum stack height : "+app.maxHeight(cuboids));
    }
    public int maxHeight(int[][] cuboids) {
        for (int[] cub: cuboids) Arrays.sort(cub); //ascending(or descending) sort each cuboids , max height at last
        Arrays.sort(cuboids,(a,b)->b[0]*b[1]*b[2]-a[0]*a[1]*a[2]); //max height wise tie breaker descending sort.

        n = cuboids.length;     memLDSHeight = new int[n][n];
        return exploreMaxStacking(0,-1,cuboids);
    }
    int[][] memLDSHeight;   int n;//LDS- longest decreasing subsequence
    private int exploreMaxStacking(int curr,int prev,int[][] cuboids){
        if (curr==n) return 0;//no more height gain
        if (memLDSHeight[curr][prev+1]!=0) return memLDSHeight[curr][prev+1];

        int skip = exploreMaxStacking(curr+1, prev, cuboids); //do not place this cuboid

        int take = 0;
        if (prev==-1 || smallOrEqual(cuboids[curr], cuboids[prev])) //place this cuboid on top of the prev cuboid if this is smaller or equal to prev cuboid.
            take = cuboids[curr][2] + exploreMaxStacking(curr+1, curr, cuboids);

        return memLDSHeight[curr][prev+1] = Math.max(skip,take);
    }

    private boolean smallOrEqual(int[] currCub,int[] prevCub){
        for (int i = 0; i <=2; i++)
            if (currCub[i]>prevCub[i]) return false; //checking all 3 dimensions smaller/equal, else false
        return true;
    }
}