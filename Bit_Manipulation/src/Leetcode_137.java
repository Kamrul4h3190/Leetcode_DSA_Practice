public class Leetcode_137 {
    public static void main(String[] args) {
        Leetcode_137 app = new Leetcode_137();
        int[] nums = {2,2,3,2};
        System.out.println("single number : "+app.singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int single=0;
        for (int k = 0; k < 32; k++) {// visiting k th bits of each number
            int countOne = 0;
            for (int num : nums)
                if((1<<k&num) !=0) countOne++;//by left shift
//                if((num >> k & 1) == 1) countOne++;// by right shift

            if (countOne % 3==1) //exact thrice numbers will cancel ,remainder bit is the single numbers bit
                single = single | 1<<k; //set kth bit of the single number
        }
        return single;
    }
}
