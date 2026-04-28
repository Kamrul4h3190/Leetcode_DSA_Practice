public class Leetcode_3036 {
    public static void main(String[] args) {
        Leetcode_3036 app = new Leetcode_3036();
        int[] nums = {1,2,3,4,5,6}, pattern = {1,1};
        System.out.println("pattern found :"+app.countMatchingSubarrays(nums,pattern));
    }
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length,m = pattern.length;
        int[] newNums = new int[n-1];
        for (int i = 1; i < n; i++) {//generate the whole new pattern following the original pattern rules
            if (nums[i]>nums[i-1])  newNums[i-1] = 1;
            else if (nums[i]<nums[i-1])  newNums[i-1] = -1;
            else newNums[i-1] = 0;
        }

        int[] lps = new int[m];
        fillLPS(pattern,lps);

        int found = 0;
        int i = 0, j = 0;
        //KMP
        while (i < newNums.length) {
            if (newNums[i] == pattern[j]) {//matched
                i++;    j++;

                if (j == m) { // pattern matched
                    found++;
                    j = lps[j - 1];//for exploring next occurrences of pattern
                }
            } else {//Not matched
                if (j != 0)
                    j = lps[j - 1];
                else i++;
            }
        }

        return found;
    }

    private void fillLPS(int[] pattern, int[] lps){
        int m = pattern.length;
        int len=0;
        int i = 1;
        while (i<m){
            if (pattern[i]==pattern[len]){
                len++;
                lps[i] = len;
                i++;
            }else {
                if (len!=0)
                    len = lps[len-1];
                else i++;
            }
        }
    }
}