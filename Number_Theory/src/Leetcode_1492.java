public class Leetcode_1492 {
    public static void main(String[] args) {
        Leetcode_1492 app = new Leetcode_1492();
        int n=2, k=2;
//        int n = 7, k=2;
//        int n = 12, k=3;
        System.out.println("K th factor : "+app.kthFactor(n,k));
    }
    public int kthFactor(int n,int k) {
        for (int i = 1; i*i <= n; i++) {//forward check upto route(n)
            if (n%i==0) k--;
            if (k==0) return i;
        }
        for (int i = (int) (Math.sqrt(n-1)); i >=1 ; i--) {//back one index, backward check
            if (n%i==0) k--;
            if (k==0) return n/i;
        }
        return -1;
    }
}
