public class Leetcode_287 {
    public static void main(String[] args) {
        Leetcode_287 app = new Leetcode_287();
        int[] nums = {1,3,4,2,2};
        System.out.println("duplicate number : "+app.findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        int requiredBits = 1; //minimum number 1, at least 1 bit is necessary
        int n1=n;
        while ((n1=n1>>1)!=0) requiredBits++;

        int[] bitsCount1toN = new int[requiredBits];//count the bits 1-n
        for (int num = 1; num <= n; num++) {
            for (int shift = 0; shift < requiredBits; shift++) {
                if ((num & 1<<shift) !=0)
                    bitsCount1toN[shift]++;
            }
        }
        int[] bitsCountNums = new int[requiredBits];//count the bits of inputs
        for (int num : nums) {
            for (int shift = 0; shift < requiredBits; shift++) {
                if ((num & 1<<shift)!=0)
                    bitsCountNums[shift]++;
            }
        }

        int duplicate = 0;//generate the duplicate with the extra bits of the inputs
        for (int shift = 0; shift < requiredBits; shift++) {
            if (bitsCountNums[shift]>bitsCount1toN[shift])
                duplicate |= 1<<shift;
        }

        return duplicate;
    }
}
//    public static int findDuplicate_bit(int[] nums) {
//        int n = nums.length;
//        int ans = 0;
//        int bit_max = 31;
//        while (((n - 1) >> bit_max) == 0) {
//            bit_max -= 1;
//        }
//
//        for (int bit = 0; bit <= bit_max; ++bit) {
//            int x = 0, y = 0;
//            for (int i = 0; i < n; ++i) {
//                if ((nums[i] & (1 << bit)) != 0) {
//                    x += 1;
//                }
//                if (i >= 1 && ((i & (1 << bit)) != 0)) {
//                    y += 1;
//                }
//            }
//            if (x > y) {
//                ans |= 1 << bit;
//            }
//        }
//
//        return ans;
//    }