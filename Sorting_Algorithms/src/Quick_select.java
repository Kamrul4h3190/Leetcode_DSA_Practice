import java.util.Arrays;

public class Quick_select {
    public static void main(String[] args) {
        Quick_select select = new Quick_select();
                    //0 1 2 3 4 5 6 7
        int[] nums = {6,8,7,5,9,1,2,3};
        int k = 4;//select kth smallest
        System.out.println("K th smallest : "+ select.quickSelect(0, nums.length-1,k,nums));
    }
    public int quickSelect(int left, int right,int k, int[] nums){
        int pivot = partition(nums, left, right);
        if (pivot==k-1) return nums[pivot];//kth smallest is at k-1 index

        if (pivot>k-1) return quickSelect(left, pivot-1, k, nums);
        return quickSelect( pivot+1, right, k, nums);
    }

    private int partition(int[] nums,int left,int right){
        int pivot = left;
        int i = pivot+1, j = right;
        while (i<=j){
            if (nums[i]>nums[pivot] && nums[j]<nums[pivot]){//for kth largest sort descending.reverse logics in this while loop
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