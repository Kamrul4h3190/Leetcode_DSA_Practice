import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {
        Insertion_sort sort = new Insertion_sort();
        int[] nums = {7,3,5,2,3,1,5,8};
        System.out.println("sorted : "+ Arrays.toString(sort.insertionSort(nums)));
    }

    public int[] insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i-1;
            while (j>=0 && nums[j]>current){
                nums[j+1] = nums[j];
                j--;
            }
            j++;//revert the last backing

            nums[j] = current;
        }
        return nums;
    }

}