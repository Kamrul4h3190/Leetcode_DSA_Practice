public class Leetcode_50 {
    public static void main(String[] args) {
        Leetcode_50 app = new Leetcode_50();
        double x = 2.0; int n = -3;
        System.out.println("power of : "+app.myPow(x,n));
    }
    public double myPow(double x, int n) {
        return solve(x,n);
    }

    private double solve(double x,long n){ //long - n may overflow
        if (n==0) return 1;
        //reduce to power of 2, and half the power
        if (n<0) return solve(1/x,-n);//negative power
        if (n%2==0) return solve(x*x,n/2);//even power
        return x * solve(x*x,(n-1)/2);//odd power
    }
}
