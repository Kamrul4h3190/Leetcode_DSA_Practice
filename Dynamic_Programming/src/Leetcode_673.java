public class Leetcode_673 {
    public static void main(String[] args) {
        Leetcode_673 app = new Leetcode_673();
//        int[] nums = {0,1,0,3,2,3};
//        int[] nums = {1,3,5,4};
        int[] nums = {1,3,5,4,7};
//        int[] nums = {2,2,2,2,2};
//        System.out.println("length of LIS : "+app.lengthOfLIS(nums));
        System.out.println("count of LIS : "+app.findNumberOfLIS(nums));
    }
    public int findNumberOfLIS(int[] nums) {
        n=nums.length; memLISPairs = new Pair[n][n];
        return generatePair(0,-1,nums).getFreq();
    }
    Pair[][] memLISPairs;   int n;
    private Pair generatePair(int curr,int prev,int[] nums){
        if (curr==n) return new Pair(0,1);
        if (memLISPairs[curr][prev+1]!=null) return memLISPairs[curr][prev+1];

        int length=0,freq=0;
        if (prev==-1 || nums[curr]>nums[prev]){ //include number[curr] in running LIS
            Pair take = generatePair(curr+1, curr, nums);
            int takenLength = 1+take.getLength();
            if (takenLength>length){ //new grater LIS found update length,freq
                length = takenLength;
                freq = take.getFreq();
            }else if (takenLength==length) freq+=take.getFreq();//LIS found of same length , update freq
        }

        Pair skip = generatePair(curr+1, prev, nums);   //do not include number[curr] in running LIS
        int skipLength = skip.getLength();
        if (skipLength>length){//new grater LIS found update length,freq
            length = skipLength;
            freq = skip.getFreq();
        }else if (skipLength==length) freq+=skip.getFreq();//LIS found of same length , update freq

        return memLISPairs[curr][prev+1] = new Pair(length,freq);
    }


    public class Pair{
        private int length=0,freq=0;
        public Pair(int length, int freq) {
            this.length = length;
            this.freq = freq;
        }
        public int getLength() {return length;}
        public int getFreq() {return freq;}
    }
}