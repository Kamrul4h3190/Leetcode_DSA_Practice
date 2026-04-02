import java.util.*;

public class Leetcode_1923 {
    public static void main(String[] args) {
        Leetcode_1923 app = new Leetcode_1923();
//        int[] nums1 = {0,0,0,0,0}, nums2 = {0,0,0,0,0};
        int n = 5; int[][]paths = {{0,1,2,3,4},{2,3,4}, {4,0,1,2,3}};
//        int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        System.out.println("LCS length :"+app.longestCommonSubpath(n,paths));
    }
    public int longestCommonSubpath(int n, int[][] paths)
    {
        int len=0;
        int minLen = Integer.MAX_VALUE;
        for (int[] path : paths) minLen = Math.min(minLen, path.length);

        int left=1,right= minLen;
        while (left<=right){
            int mid = left+(right-left)/2;

            if (lcsFound(paths, mid)){
                len = mid;
                left = mid+1;
            }
            else right = mid-1;
        }
        return len;
    }

    boolean lcsFound(int[][] paths,int len)
    {
        long mod1 = (long) 1e9+7;
        long mod2 = (long) 1e9+9;

        long base1 = (long) (1e6+3);
        long base2 = (long) (1e6+33);

        Set<DoubleHash> allPathHashes = null ;
        for(int[] path : paths)
        {
            int m = path.length ;

            long[] hash1 = new long[m+1] ;
            long[] hash2 = new long[m+1] ;
            long[] pow1 = new long[m+1] ;
            long[] pow2 = new long[m+1] ;

            pow1[0] = 1 ;
            pow2[0] = 1 ;

            for (int i = 0; i < m; i++) {
                hash1[i+1] = (hash1[i]*base1 + path[i])%mod1;
                hash2[i+1] = (hash2[i]*base2 + path[i])%mod2;
                pow1[i+1] = (pow1[i] * base1) % mod1 ;
                pow2[i+1] = (pow2[i] * base2) % mod2 ;
            }

            Set<DoubleHash> currPathHashes = new HashSet<>() ;
            for (int i = 0; i+len <= m; i++) {
                long windowHash1 = (hash1[i+len]-hash1[i]*pow1[len]%mod1 + mod1)%mod1;
                long windowHash2 = (hash2[i+len]-hash2[i]*pow2[len]%mod2 + mod2)%mod2;
                currPathHashes.add(new DoubleHash(windowHash1,windowHash2));
            }

            if(allPathHashes == null)
                allPathHashes = currPathHashes ;
            else
            {
                allPathHashes.retainAll(currPathHashes) ;//intersection, only commons will stay
                if(allPathHashes.isEmpty()) return false ;
            }
        }

        return !allPathHashes.isEmpty() ;//true if exists some hash common across paths of this length
    }


    class DoubleHash
    {
        long hash1 ;
        long hash2 ;
        DoubleHash(long hash1, long hash2)
        {
            this.hash1 = hash1 ;
            this.hash2 = hash2 ;
        }
        @Override
        public boolean equals(Object o)
        {
            if(!(o instanceof DoubleHash)) return false ;
            DoubleHash dh = (DoubleHash) o ;
            return hash1 == dh.hash1 && hash2 == dh.hash2 ;
        }
        @Override
        public int hashCode() {return Objects.hash(hash1, hash2) ;}
    }
}