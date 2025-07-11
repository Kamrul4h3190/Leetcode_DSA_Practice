import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        Selection_sort sort = new Selection_sort();
        int[] nums = {2,8,3,5,7,6};
        System.out.println("sorted : "+ Arrays.toString(sort.selectionSort(nums)));
    }

    public int[] selectionSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[j]<nums[minIndex]){
                    minIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

}