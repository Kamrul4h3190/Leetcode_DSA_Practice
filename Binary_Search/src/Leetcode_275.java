public class Leetcode_275 {
    public static void main(String[] args) {
        Leetcode_275 app = new Leetcode_275();
        int[] citations = {0,1,3,5,6};
        System.out.println("H index : "+app.hIndex(citations));
    }
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l=0; int r = n-1;
        while (l<=r){
            int mid = l+(r-l)/2;    int target = n-mid;
            if (citations[mid]==target) return target;// at least target number of citations ahead with minimum target citations.

            if (citations[mid] < target) l=mid+1;
            else r = mid-1;
        }
        return n-l; //h score not from citations
    }
}