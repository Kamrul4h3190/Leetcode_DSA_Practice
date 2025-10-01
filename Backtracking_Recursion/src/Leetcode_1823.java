public class Leetcode_1823 {
    public static void main(String[] args) {
        Leetcode_1823 app = new Leetcode_1823();
        int n = 5,k=2;
        System.out.println("winner : "+app.findTheWinner(n,k));
    }
    public int findTheWinner(int n, int k) {
        return recursion(n, k) + 1;
    }

    private int recursion(int n, int k) {
        if (n == 1) return 0;
        return (recursion(n-1,k) + k)%n;
    }
}
