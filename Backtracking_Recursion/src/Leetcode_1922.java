public class Leetcode_1922 {
    public static void main(String[] args) {
        Leetcode_1922 app = new Leetcode_1922();
        long n = 4;
        System.out.println("good strings : "+app.countGoodNumbers(n));
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2, odd = n/2; //number of even/odd indices in n length number
        return (int) (calculatePower(5,even) * calculatePower(4,odd)%mod);//5 even digits, 4 prime digits
    }
    int mod = (int) 1e9+7;
    private long calculatePower(long x, long n){ //long - n may overflow
        if (n==0) return 1;
        //reduce to power of 2
        long temp  = calculatePower(x,n/2);
        if (n%2==0) return (temp*temp) % mod;//even
        return (x*temp*temp) % mod;//odd
    }
}
