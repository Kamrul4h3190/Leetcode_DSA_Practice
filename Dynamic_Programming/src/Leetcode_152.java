public class Leetcode_152 {
    public static void main(String[] args) {
        Leetcode_152 app = new Leetcode_152();
        int[] nums = {-3,4,-1,2,1,-5};
//        int[] nums = {3,-1,4};
//        int[] nums = {0,2};
//        int[] nums = {-3,-1,-1};
//        int[] nums = {-2,0,-1};
//        int[] nums = {2,3,-2,4};
        System.out.println("max product Subarray : "+ app.maxProduct(nums));
    }
    public int maxProduct(int[] nums) { //kadane algo
        int currProd=1;
        int maxProd=nums[0];
        for(int num:nums){//forward max
            currProd *= num;
            if(currProd>maxProd) maxProd = currProd;
            if(currProd==0) currProd = 1;
        }

        currProd=1;//backward max
        for (int i = nums.length-1; i >= 0; i--) {
            currProd *= nums[i];
            if (currProd>maxProd) maxProd = currProd;
            if (currProd==0) currProd = 1;
        }
        return maxProd;
    }
}