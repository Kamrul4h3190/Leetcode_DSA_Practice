import java.util.*;

public class Leetcode_1461 {
    public static void main(String[] args) {
        Leetcode_1461 app = new Leetcode_1461();
        String s = "00110";int k = 2;
//        String s = "0110";int k = 1;
//        String s = "00110110";int k = 2;
        System.out.println("all binary found :"+app.hasAllCodes(s,k));
    }

    long base = 29;
    long mod = (long) 1e9+7;
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        Set<Long> binarySet = new HashSet<>();
        long[] sHash = new long[n];
        long[] power = new long[n];
        sHash[0] = s.charAt(0);
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            sHash[i] = (sHash[i-1]* base + s.charAt(i))% mod;
            power[i] = (power[i-1]* base)% mod;
        }

        for (int i = 0; i+k <= n; i++) {
            long hash = getHash(i, i+k-1,sHash,power);
            binarySet.add(hash);
            if (binarySet.size() == (1 << k))   return true;
        }

        return false;
    }

    private long getHash(int l, int r, long[] hash, long[] pow) {
        if (l == 0) return hash[r];
        return (hash[r]-(hash[l-1]*pow[r-l+1])%mod+mod)%mod;//r-l+1 = size of the substring, for equalizing the powers before subtraction
    }
}