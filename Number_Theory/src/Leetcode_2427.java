public class Leetcode_2427 {
    public static void main(String[] args) {
        Leetcode_2427 app = new Leetcode_2427();
//        int a = 25,b=30;
        int a = 12,b=16;
        System.out.println(" number of common factors : "+app.commonFactors(a,b));
    }
    public int commonFactors(int a, int b) {
        int g = gcd(a,b); //check upto GCD/min(a,b)
        int count = 0;
        for (int i = 1; i*i <= g; i++){
            if (g%i==0){
                if (i*i==g)//perfect square divisor,only 1 divisor
                    count++;
                else count+=2;//other divisor, pair of divisor.
            }

        }
        return count;
    }
    private int gcd(int a,int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}
