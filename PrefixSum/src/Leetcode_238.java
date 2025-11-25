import java.util.Arrays;

public class Leetcode_238 {
    public static void main(String[] args) {
        Leetcode_238 app = new Leetcode_238();
        int[] nums = {1,2,3,4};
        System.out.println("product except selft : "+ Arrays.toString(app.productExceptSelf(nums)));
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int products[] = new int[n];
        Arrays.fill(products, 1);
        int prefixProd = 1;
        for (int i = 0; i < n; i++) {//update current product, calculate for the next with current nums[i], that is excluding the current num
            products[i] *= prefixProd;
            prefixProd *= nums[i];
        }

        int suffixProd = 1; //backward
        for (int i=n-1 ; i>=0 ; i--) {
            products[i] *= suffixProd;
            suffixProd *= nums[i];
        }
        return products;
    }
}