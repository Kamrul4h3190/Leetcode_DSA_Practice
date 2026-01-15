import java.util.Arrays;

public class Leetcode_88 {
    public static void main(String[] args) {
        Leetcode_88 sort = new Leetcode_88();
        int[] nums1 = {1,2,3,0,0,0};int[] nums2 = {2,5,6}; int m = 3,n=3;
        sort.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    public void merge(int[] nums1,int m,int[] nums2,int n){
        if(n==0) return;
        if (m==0){//first array is empty , copy all from second array
            int i = 0;
            for (int n2 : nums2) nums1[i++] = n2;
            return;
        }
        int[] merged = new int[m+n];//simple merge
        int i=0,j=0,k=0;
        while (i<m && j<n){
            if (nums1[i]<=nums2[j])
                merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }
        while (i<m) merged[k++] = nums1[i++];
        while (j<n) merged[k++] = nums2[j++];

        i=0;//copy back to nums1
        for (int num : merged) nums1[i++] = num;
    }
}