public class Leetcode_1979 {
    public static void main(String[] args) {
        Leetcode_1979 app = new Leetcode_1979();
        int[] nums = {2,5,6,9,10};
        System.out.println("GCD of min and max : "+app.findGCD(nums));
    }
    public int findGCD(int[] nums) {
        int max =  Integer.MIN_VALUE;   int min = Integer.MAX_VALUE;
        for (int num :nums) {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        return gcd(max,min);
    }
    private int gcd(int a,int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
