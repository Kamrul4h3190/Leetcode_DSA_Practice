public class Leetcode_1043 {
    public static void main(String[] args) {
        Leetcode_1043 app = new Leetcode_1043();
        int[] arr = {1,15,7,9,2,5,10}; int k=3;
        System.out.println("largest partition sum : "+app.maxSumAfterPartitioning(arr,k));
    }
    public int maxSumAfterPartitioning(int[] arr,int k) {
        n = arr.length;    memPartitionSums = new Integer[n];
        return explorePartitions(0,k,arr);
    }
    Integer[] memPartitionSums; int n; // Time O(n*k)
    private int explorePartitions(int i,int k, int[] arr){
        if (i==n) return 0;
        if (memPartitionSums[i]!=null) return memPartitionSums[i];

        int maxPartitionSum= 0;
        int partitionMax = 0;
        int  partitionEnd = i+k;
        for (int j = i; j < n && j<partitionEnd  ; j++) {
            partitionMax = Math.max(partitionMax,arr[j]);
            int partitionSum =  partitionMax*(j-i+1) + //k = j-i+1 , how many k we have taken(size of partition)
                    explorePartitions(j+1, k, arr);
            maxPartitionSum = Math.max(maxPartitionSum,partitionSum);
        }

        return memPartitionSums[i] = maxPartitionSum;
    }
}