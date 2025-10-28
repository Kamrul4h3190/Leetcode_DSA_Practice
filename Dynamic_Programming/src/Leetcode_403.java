import java.util.*;

public class Leetcode_403 {
    public static void main(String[] args) {
        Leetcode_403 app = new Leetcode_403();
//        int[] stones = {0,1,3};
//        int[] stones = {0,1,2,3,4,8,9,11};
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println("frog river cross : "+app.canCross(stones));
    }

    public boolean canCross(int[] stonePositions) {
        if (stonePositions[1] != 1) return false; //first jump is 1 step
        stoneIndexMap = new HashMap<>();   n = stonePositions.length;
        for (int i = 1; i < n; i++) stoneIndexMap.put(stonePositions[i],i);//store positions->indices
        memJumps = new Boolean[n][n];
        return dynamicJump(1,1,stonePositions);
    }
    Map<Integer,Integer> stoneIndexMap;    Boolean[][] memJumps;    int n;
    private boolean dynamicJump(int stoneIndex,int kStep,int[] stonePositions){
        if (stoneIndex==n-1) return true;   //reached last stone
        if (memJumps[stoneIndex][kStep] != null) return memJumps[stoneIndex][kStep];

        boolean riverCross = false;
        for (int k = kStep-1; k <= kStep + 1; k++) {
            int nextStonePosition = stonePositions[stoneIndex] + k ; // curr stone position + k steps
            if (nextStonePosition > stonePositions[stoneIndex] && stoneIndexMap.containsKey(nextStonePosition))
                riverCross = riverCross ||      // if next position forwards and next position available in stonePositions[](map)
                        dynamicJump(stoneIndexMap.get(nextStonePosition), k, stonePositions);
        }
        return memJumps[stoneIndex][kStep] = riverCross;
    }
}