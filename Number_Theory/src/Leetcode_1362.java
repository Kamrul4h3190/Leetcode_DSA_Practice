import java.util.Arrays;

public class Leetcode_1362 {
    public static void main(String[] args) {
        Leetcode_1362 app = new Leetcode_1362();
        int n = 8;
        System.out.println("closest divisors : "+ Arrays.toString(app.closestDivisors(n)));
    }
    public int[] closestDivisors(int num) {
        int n1 = num+1,n2 = num+2;
        int minDiff = n2;
        int[] closest = new int[]{1,n2};
        for (int i = 1; i*i<=n2; i++) {
            if (n1%i==0){
                int j = n1/i;
                if (j-i<minDiff){
                    minDiff = j-i;
                    closest = new int[]{i,j};
                }
            }
            if (n2%i==0){
                int j = n2/i;
                if (j-i<minDiff){
                    minDiff = j-i;
                    closest = new int[]{i,j};
                }
            }
        }
        return closest;
    }
}
