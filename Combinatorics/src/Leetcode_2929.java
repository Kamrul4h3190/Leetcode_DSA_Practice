public class Leetcode_2929 {
    public static void main(String[] args) {
        Leetcode_2929 app = new Leetcode_2929();
        int n=5,limit =2;
        System.out.println("candy distribute ways : "+app.distributeCandies(n,limit));
    }
    public long distributeCandies(int n, int limit) {
        int minCh1 = Math.max(0,n-2*limit); // ch2 = limit, ch3 = limit
        int maxCh1 = Math.min(n,limit);
        long ways = 0;
        for (int i = minCh1; i <=maxCh1 ; i++) { //calculate ch1
            //calculate rest for ch2 giving maximum limit candy to ch3
            int leftCandy = n-i;
            int minCh2 = Math.max(0,leftCandy-limit);
            int maxCh2 = Math.min(leftCandy,limit);

            ways+= maxCh2-minCh2 + 1;
        }
        return ways;
    }
}
