public class Leetcode_2141 {
    public static void main(String[] args) {
        Leetcode_2141 app = new Leetcode_2141();
        int[] batteries = {10, 10, 3, 5};
        int n = 3;
//        int[] batteries = {1,1,1,1}; int n = 2;
//        int[] batteries = {3,3,3}; int n = 2;
//        int[] nums = {1,2,3,4,5}; int k = 2;
        System.out.println("maximum simultaneous runtime : " + app.maxRunTime(n, batteries));
    }

    public long maxRunTime(int n, int[] batteries) {
        long batSum = 0;
        for (int bat : batteries) batSum += bat;
        long left = 1;
        long right = batSum / n; //maximum of this conquerent battery sum is needed

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (!canRun(mid, n, batteries)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right; //maximize runtime
    }

    private boolean canRun(long mid, int n, int[] batteries) {
        long target = n * mid;
        long simultanousSum = 0;
        for (long bat : batteries) {
            if (bat >= mid)
                simultanousSum += mid;
            else simultanousSum += bat;
            if (simultanousSum >= target) return true;
        }
        return false;
    }
}