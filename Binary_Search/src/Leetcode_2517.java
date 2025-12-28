import java.util.Arrays;

public class Leetcode_2517 {
    public static void main(String[] args) {
        Leetcode_2517 app = new Leetcode_2517();
//        int[] price = {13,5,1,8,21,2}; int k = 3;
        int[] price = {7,7,7,7}; int k = 2;
//        int[] price = {1,3,1}; int k = 2;
        System.out.println("maximum tasty basket : "+app.maximumTastiness(price,k));
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0;
        int right = price[price.length-1]-price[0];
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(basketPossible(price, mid, k))
                left=mid+1;
            else
                right = mid-1;
        }
        return right;
    }
    private boolean basketPossible(int[] price, int minPrice, int k)
    {
        int candies=1;
        int lastCandyPrice = price[0];
        for(int i=1;i<price.length;i++)
        {
            if(price[i]-lastCandyPrice>=minPrice) {
                candies++;
                if(candies>=k) return true;
                lastCandyPrice = price[i];
            }
        }
        return false;
    }
}