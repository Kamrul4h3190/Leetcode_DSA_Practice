public class Leetcode_852 {
    public static void main(String[] args) {
        Leetcode_852 app = new Leetcode_852();
        int[] arr = {0,2,1,0};
        System.out.println("peak index : "+ app.peakIndexInMountainArray(arr));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0; int right = arr.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            if (arr[mid]>arr[mid+1])//we need the first occurrence of this condition
                right = mid;
            else left = mid+1;
        }
        return left;
    }
}