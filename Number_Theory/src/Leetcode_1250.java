public class Leetcode_1250 {
    public static void main(String[] args) {
        Leetcode_1250 app = new Leetcode_1250();
        int[] nums = {12,5,7,23};
        System.out.println("good array(contains co prime) : "+app.isGoodArray(nums));
    }
    public boolean isGoodArray(int[] nums) {//bezout's identity
        int gcd = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            gcd = gcd(gcd,nums[i]);
            if (gcd==1) return true;//array contains co prime numbers
        }
        return gcd==1 ;
    }
    private int gcd(int a,int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
