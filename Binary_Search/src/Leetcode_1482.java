public class Leetcode_1482 {
    public static void main(String[] args) {
        Leetcode_1482 app = new Leetcode_1482();
        int[] bloomDay = {7,7,7,7,12,7,7}; int m = 2; int k = 3;
        System.out.println("minimum days to make bouquets : "+ app.minDays(bloomDay,m,k));
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m*k > bloomDay.length) return -1;//less flowers. possible overflow
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int w : bloomDay){
            left = Math.min(left,w);
            right = Math.max(right,w);
        }

        while (left<right){
            int mid = left+(right-left)/2;
            if (bouquetsPossible(mid,m,k,bloomDay))
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
    private boolean bouquetsPossible(int day, int m, int k, int[] bloomingDays){
        int flowers = 0,bouquets=0;
        for (int bloomDay : bloomingDays) {
            if (bloomDay<=day){//all the flowers bloomed earlier is still bloomed, we can pick that flowers
                flowers++;
                if (flowers==k){//found k consecutive flowers. this will form a bouquet.
                    bouquets++;
                    if (bouquets>=m) return true; //m bouquets formed, return early
                    flowers = 0;//reset after successfully made a bouquet
                }
            }else flowers = 0;//if bloom day is greater reset flowers
        }
        return false;
    }
}