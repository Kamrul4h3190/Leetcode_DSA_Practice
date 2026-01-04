import java.util.Arrays;

public class Leetcode_2528 {
    public static void main(String[] args) {
        Leetcode_2528 app = new Leetcode_2528();
//        int[] staions = {4,2}; int r=1,k = 1;
//        int[] staions = {1,2,4,5,0}; int r=1,k = 2;
        int[] staions = {4,4,4,4}; int r=0,k = 3;
        System.out.println("maximum min power : "+app.maxPower(staions,r,k));
    }
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] diff = new long[n];

        // Build difference array
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = i + r + 1;
            diff[left] += stations[i];
            if (right < n) diff[right] -= stations[i];
        }

        long left = Arrays.stream(stations).min().getAsInt();
        long right = Arrays.stream(stations).asLongStream().sum() + k;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(mid, diff, r, k, n)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;//minimum max
    }
    private boolean check(long mid, long[] diff, int r, long k, int n) {
        long[] tempDiff = Arrays.copyOf(diff, n);//objects and array are passed by reference, we need a fresh copy each time
        long cumSum = 0;

        for (int i = 0; i < n; i++) {
            cumSum += tempDiff[i];

            if (cumSum < mid) {
                long need = mid - cumSum;
                if (need > k) {
                    return false;
                }

                k -= need;
                cumSum += need;

                // apply difference array logic
                if (i + 2 * r + 1 < n) {
                    tempDiff[(i + 2 * r + 1)] -= need;
                }
            }
        }
        return true;
    }
}