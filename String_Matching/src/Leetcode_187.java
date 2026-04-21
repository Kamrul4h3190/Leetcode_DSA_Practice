import java.util.*;

public class Leetcode_187 {
    public static void main(String[] args) {
        Leetcode_187 app = new Leetcode_187();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("DNA repeats :"+app.findRepeatedDnaSequences(s));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n < 10) return new ArrayList<>();

        long[] hash1 = new long[n];
        long[] hash2 = new long[n];
        long[] pow1 = new long[n];
        long[] pow2 = new long[n];

        hash1[0] = s.charAt(0) - 'A';
        hash2[0] = s.charAt(0) - 'A';
        pow1[0] = 1;
        pow2[0] = 1;

        for (int i = 1; i < n; i++) {
            int val = s.charAt(i) - 'A';

            hash1[i] = (hash1[i - 1] * base1 + val) % mod1;
            hash2[i] = (hash2[i - 1] * base2 + val) % mod2;

            pow1[i] = (pow1[i - 1] * base1) % mod1;
            pow2[i] = (pow2[i - 1] * base2) % mod2;
        }

        Set<Long> seen = new HashSet<>();
        Set<String> repeats = new HashSet<>();

        for (int left = 0; left + 10 <= n; left++) {
            long h1 = getHash(left, left + 9, hash1, pow1, mod1);
            long h2 = getHash(left, left + 9, hash2, pow2, mod2);

            // combine two hashes into one long
            long combined = (h1 << 32) | h2;

            if (seen.contains(combined)) {
                repeats.add(s.substring(left, left + 10));
            } else {
                seen.add(combined);
            }
        }

        return new ArrayList<>(repeats);
    }

    long base1 = 29, base2 = 31;
    long mod1 = (long) 1e9 + 7;
    long mod2 = (long) 1e9 + 9;

    private long getHash(int l, int r, long[] hash, long[] pow, long mod) {
        if (l == 0) return hash[r];
        return (hash[r] - (hash[l - 1] * pow[r - l + 1]) % mod + mod) % mod;
    }
}