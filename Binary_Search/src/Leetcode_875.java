public class Leetcode_875 {
    public static void main(String[] args) {
        Leetcode_875 app = new Leetcode_875();
        int[] piles = {30,11,23,4,20}; int h = 5;
        System.out.println("minimum eating rate : "+ app.minEatingSpeed(piles,h));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int w : piles) right = Math.max(right,w);

        while (left<right){
            int mid = left+(right-left)/2;
            if (eatInTime(mid,h,piles))
                right = mid;
            else
                left = mid+1;
        }
        return left; //converged to mid minimum(eating rate k)
    }
    private boolean eatInTime(int time, int timeAllowed, int[] piles){
        int timeElapsed = 0;
        for (int bananas : piles) {
            timeElapsed += Math.ceilDiv(bananas,time); //ceil : remaining bananas take additional 1 hour
            if (timeElapsed>timeAllowed) return false;
        }
        return true;
    }
}