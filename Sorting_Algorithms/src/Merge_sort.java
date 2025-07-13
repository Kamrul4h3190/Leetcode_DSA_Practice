import java.util.Arrays;

public class Merge_sort {
    public static void main(String[] args) {
        Merge_sort sort = new Merge_sort();
        int[] nums = {2,8,3,5,7,3,6};
//        int[] nums = {6,3,9,5,2,8};
//        sort.mergeSort(nums);
        System.out.println(Arrays.toString(sort.mergeSort(nums)));
    }

    public int[] mergeSort(int[] nums){
        int n = nums.length;
        if (n<2) return nums;//single length

        int mid = n/2;//create backward combining array in the time of splitting.
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[n-mid];
        for (int i = 0; i < mid; i++) leftHalf[i] = nums[i];
        for (int i = mid; i < n; i++) rightHalf[i-mid] = nums[i];

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        return merge(leftHalf,rightHalf,nums);
    }

    private int[] merge(int[] leftHalf,int[] rightHalf,int[] callerNums){
        int leftSize = leftHalf.length,rightSize = rightHalf.length;

        int i=0,j=0,k=0;
        while (i<leftSize && j<rightSize){//no need to create new combined array. Overwrite in caller nums.
            if (leftHalf[i]<rightHalf[j])callerNums[k++] = leftHalf[i++]; //increase k,i after using the current value
            else callerNums[k++] = rightHalf[j++];
//            if (leftHalf[i]<rightHalf[j]){callerNums[k]=leftHalf[i]; i++;}
//            else {callerNums[k] = rightHalf[j]; j++;}
//
//            k++;
        }

        while (i<leftSize) callerNums[k++] = leftHalf[i++];
        while (j<rightSize) callerNums[k++] = rightHalf[j++];

        return callerNums;
    }
}