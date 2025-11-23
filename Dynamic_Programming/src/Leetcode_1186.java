public class Leetcode_1186 {
    public static void main(String[] args) {
        Leetcode_1186 app = new Leetcode_1186();
        int[] arr = {1,-2,0,3};
        System.out.println("max subArray sum with one(optional) deletion : "+ app.maximumSum(arr));
    }
    public int maximumSum(int[] arr) {
        int deleteSum = 0;
        int takeSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            deleteSum = Math.max( arr[i]+deleteSum , Math.max(takeSum , arr[i]) ); //delete is optional , maximizing can be done 3 ways
            takeSum = Math.max(arr[i]+takeSum , arr[i]); //take all, no deletion

            maxSum = Math.max(maxSum,
                    Math.max(deleteSum,takeSum));
        }

        return maxSum;
    }
}