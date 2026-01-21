import java.util.Arrays;

public class Leetcode_4 {
    public static void main(String[] args) {
        Leetcode_4 app = new Leetcode_4();
        int[] nums1 = {1,3,8},nums2 = {7,9,10,11};
        System.out.println("median : "+ app.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small = nums1,large = nums2;
        if (nums2.length<nums1.length){small = nums2; large = nums1;}

        int start = 0,end = small.length; //end = n1 for range out cases
        int n1= small.length,n2= large.length, N= n1 +n2;
        while (start<=end){
            int mid1 = (start+end)/2;
            int mid2 = N/2 - mid1;

            int l1 = mid1-1>=0 && mid1-1<n1 ? small[mid1-1] : Integer.MIN_VALUE;
            int r1 = mid1>=0 && mid1<n1 ? small[mid1] : Integer.MAX_VALUE;
            int l2 = mid2-1>=0 && mid2-1<n2 ?  large[mid2-1] : Integer.MIN_VALUE;
            int r2 = mid2>=0 && mid2<n2 ? large[mid2] : Integer.MAX_VALUE;

            if (l1<=r2 && l2<=r1){
                if (N%2!=0) return Math.min(r1,r2);
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            } else if (l1>r2) {
                end = mid1-1;
            } else
                start = mid1+1;
        }

        return 0.0;
    }
}