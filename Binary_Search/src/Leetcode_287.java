public class Leetcode_287 {
    public static void main(String[] args) {
        Leetcode_287 app = new Leetcode_287();
        int[] nums = {1,3,4,2,2};
        System.out.println("repeating element : "+app.findDuplicate(nums));
    }
    int findDuplicate(int[] nums) { //pigeon hole principle [1,n]
        int left = 1;   int right = nums.length-1; // the repeated number is initially 1;
        while (left<right){
            int mid = left+(right-left)/2;
            int count = 0;
            for (int num : nums) if (num<=mid) count++;

            if (count>mid) /*mid=2, count >2 that means the repeating number <= mid . exclude the right half*/
                right = mid;
            else left = mid+1;
        }
        return left;//left is the repeated number
    }
}