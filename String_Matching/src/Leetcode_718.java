import java.util.HashSet;
import java.util.Set;

public class Leetcode_718 {
    public static void main(String[] args) {
        Leetcode_718 app = new Leetcode_718();
//        int[] nums1 = {0,0,0,0,0}, nums2 = {0,0,0,0,0};
        int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        System.out.println("LCS length :"+app.findLength(nums1,nums2));
    }

    public int findLength(int[] nums1,int[] nums2) {
        int len=0;
        int left=1,right= Math.min(nums1.length, nums2.length);
        while (left<=right){
            int mid = left+(right-left)/2;
            Set<Long> hashSet2 = rabinKarp(nums2,mid);
            if (lcsFound(nums1, hashSet2, mid)){
                len = mid;
                left = mid+1;
            }
            else right = mid-1;
        }
        return len;
    }
    private boolean lcsFound(int[] nums1,Set<Long> hashSet2,int len){
        long hash = initialHash(nums1,len);
        if (hashSet2.contains(hash)) return true;

        long pow = 1;
        for (int i = 1; i < len; i++) pow*=base;

        for (int i = 1; i <= nums1.length-len; i++) {//rolling hash
            hash = getNextHash(hash,pow,nums1[i-1],nums1[i+len-1]);
            if (hashSet2.contains(hash)) return true;
        }
        return false;
    }

    long base=119;
    private Set<Long> rabinKarp(int[] nums2,int len){
        Set<Long> hashSet = new HashSet<>();
        long hash = initialHash(nums2,len);
        hashSet.add(hash);

        long pow = 1;
        for (int i = 1; i < len; i++) pow*=base;

        for (int i = 1; i <= nums2.length-len; i++) {//rolling hash
            hash = getNextHash(hash,pow,nums2[i-1],nums2[i+len-1]);
            hashSet.add(hash);
        }
        return hashSet;
    }
    private long getNextHash(long currHash, long powLeft, int leftNum, int rightNum){
        return(currHash - leftNum*powLeft)*base + rightNum;
    }
    private long initialHash(int[] nums,int windowSize){
        long hash = 0;
        long pow = 1;
        for (int i = windowSize-1; i >=0 ; i--) {//backward hash axp^4+bxp^3 + .....+ exp^0
            hash+= nums[i]*pow; //power increasing from left to right
            pow*= base;
        }
        return hash;
    }
}