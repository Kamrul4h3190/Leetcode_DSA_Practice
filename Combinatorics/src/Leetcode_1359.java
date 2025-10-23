public class Leetcode_1359 {
    public static void main(String[] args) {
        Leetcode_1359 app = new Leetcode_1359();
//        int n=2;
        int n=3;
        System.out.println("delivery ways : "+app.countOrders(n));
    }

    public int countOrders(int n) {
        if(n == 1) return 1;
        int M = (int)1e9+7;
        long result = 1;
        for(int i = 2; i<=n; i++) {
            int spaces = (i-1)*2 + 1;
            int distribution = spaces * (spaces+1)/2;
            result *= distribution;
            result %= M;
        }
        return (int)result;
    }
}
