import java.util.Arrays;

public class Bubble_sort {
    public static void main(String[] args) {
        Bubble_sort sort = new Bubble_sort();
        int[] nums = {5,4,4,3,2,1};
        System.out.println("sorted : "+ Arrays.toString(sort.bubbleSort(nums)));
    }

    public int[] bubbleSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1-i; j++) {
                if (nums[j]>nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

}