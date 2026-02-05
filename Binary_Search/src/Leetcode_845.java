public class Leetcode_845 {
    public static void main(String[] args) {
        Leetcode_845 app = new Leetcode_845();
//        int[] arr = {2,3,1,2,3,4,5,6};
//        int[] arr = {9,8,7,6,5,4,3,2,1,0};
//        int[] arr = {3,3,1};
//        int[] arr = {3,3,1};
//        int[] arr = {1,3,2};
        int[] arr = {0,2,2,2,2};
//        int[] arr = {2,1,4,7,3,2,5};
//        System.out.println("peak index : "+ app.peakIndex(arr));
//        System.out.println("valley index : "+ app.valleyIndex(arr));
        System.out.println("length of longest mountain : "+app.longestMountain(arr));
    }
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n<3) return 0;

        int maxLen = 0;
        int i=0;
        boolean foundPeak = false,foundValley = false;
        while (i<n-1){
            if (arr[i]<arr[i+1]){
                int left = i;
                while (i<n-1 && arr[i]<arr[i+1]){
                    i++;
                    foundPeak = true;
                }
                while (i<n-1 && arr[i]>arr[i+1]){
                    i++;
                    foundValley = true;
                }

                if(foundPeak && foundValley)
                    maxLen = Math.max(maxLen,i-left+1);
                //reset for checking next mountains
                foundPeak = false;
                foundValley = false;
            }
            else i++;//less or equal, not rising mountain. Check next.
        }
        return maxLen;
    }
}