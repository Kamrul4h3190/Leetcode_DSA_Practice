public class Leetcode_1760 {
    public static void main(String[] args) {
        Leetcode_1760 app = new Leetcode_1760();
//        int[] nums = {7,17}; int maxOperations = 2;
//        int[] nums = {9}; int maxOperations = 2;
        int[] nums = {2,4,8,2}; int maxOperations = 4;
        System.out.println("minimum penalty : "+app.minimumSize(nums,maxOperations));
    }
    public int minimumSize(int[] nums, int maxOpr) {
        int left = 1;   int right = 0;
        for (int num : nums) right = Math.max(right,num);

        while(left<right)
        {
            int mid = left+(right-left)/2;
            if(partitionPossible(mid, maxOpr,nums))
                right = mid;
            else
                left=mid+1;
        }
        return left; //right also works
    }
    private boolean partitionPossible(int size, int maxOpr,int[] nums)
    {
        int operation = 0;
        for (int num : nums) {
            operation+= (num-1)/size;
            if (operation>maxOpr) return false;
        }
        return true;
    }
}