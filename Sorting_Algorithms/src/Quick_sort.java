import java.util.Arrays;
import java.util.Random;

public class Quick_sort {
    public static void main(String[] args) {
        Quick_sort sort = new Quick_sort();
                    //0 1 2 3 4 5 6 7
        int[] nums = {6,8,7,5,9,1,2,3};
        sort.quickSort(0, nums.length-1,nums );
        System.out.println("quick sorted : "+ Arrays.toString(nums));
    }

    public void quickSort(int start,int end,int[] nums){
        if (start>=end ) return;
        int pivot = partition(nums,start,end);

        quickSort(start, pivot-1, nums);
        quickSort(pivot+1,end, nums);
    }

    private int partition(int[] nums,int left,int right){
        int pivot = left;
        int i = pivot+1, j = right;
        while (i<=j){
            if (nums[i]>nums[pivot] && nums[j]<nums[pivot]){
                swap(i,j,nums);
                i++;j--;
            }
            if (nums[i]<=nums[pivot]) i++;
            if (nums[j]>=nums[pivot]) j--;
        }
        swap(pivot,j,nums);
        return j;
    }
    private void swap(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}