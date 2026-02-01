public class Leetcode_507 {
    public static void main(String[] args) {
        Leetcode_507 app = new Leetcode_507();
        int num = 1;
//        int num = 28;
        System.out.println("n = Sum of divisors : "+app.checkPerfectNumber(num));
    }
    public boolean checkPerfectNumber(int num) {
        if(num==1) return false;

        int i = 1;
        int sum=0;
        while(i*i<=num){//check upto root(n)
            if(num%i==0) {
                sum+=i;//divisor
                sum+=num/i;//paired divisor, after the root
            }
            i++;
        }
        sum -= num;//excluding self(num) from sum
        return sum == num;
    }
}
