import java.util.*;

public class Leetcode_3186 {
    public static void main(String[] args) {
        Leetcode_3186 app = new Leetcode_3186();
        int[] power = {7,1,6,6};
//        int[] power = {2,2,3,3,3,4};
        System.out.println("maximum points : "+app.maximumTotalDamage(power));
    }

    public long maximumTotalDamage(int[] power) {
        freq = new HashMap<>();
        for (int x : power) freq.put((long)x, freq.getOrDefault((long)x, 0L) + 1);

        List<Long> uniques = new ArrayList<>(freq.keySet());
        Collections.sort(uniques);

        n = uniques.size();    memDamage = new long[n];
        return houseRobber(0, uniques);
    }
    private Map<Long, Long> freq;   private int n; private long[] memDamage;
    private long houseRobber(int i, List<Long> uniques) {
        if (i >= n) return 0;
        if (memDamage[i] != 0) return memDamage[i];

        long skip = houseRobber(i + 1, uniques);

        int j = lowerBound(uniques, i + 1, uniques.get(i) + 3);
        long take = uniques.get(i) * freq.get(uniques.get(i)) + houseRobber(j, uniques);

        return memDamage[i] = Math.max(skip, take);
    }
    private int lowerBound(List<Long> uniques, int start, long target) {
        int low = start, high = n;
        while (low < high) {
            int mid = (low + high) / 2;
            if (uniques.get(mid) < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}