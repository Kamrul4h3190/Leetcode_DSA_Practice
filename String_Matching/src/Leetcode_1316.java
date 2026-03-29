import java.util.HashSet;

public class Leetcode_1316 {
    public static void main(String[] args) {
        Leetcode_1316 app = new Leetcode_1316();
        String text = "abaaaa";
//        String text = "abcabcabc";
        System.out.println("distinct echo substrings : "+app. distinctEchoSubstrings(text));
    }

    long base = 27L, mod = 1000000007L;

    public int distinctEchoSubstrings(String str) {
        HashSet<Long> set = new HashSet<>();
        int n = str.length();
        if (n == 0) return 0;

        long[] hash = new long[n];
        long[] power = new long[n];
        hash[0] = str.charAt(0);
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            hash[i] = (hash[i-1]* base + str.charAt(i))% mod;
            power[i] = (power[i-1]* base)% mod;
        }
        for (int i = 0; i < n; i++) {
            for (int len = 2; i+len <= n; len+=2) {
                int mid = i+len/2;
                long h1 = getHash(i,mid-1,hash,power);//-1 ,0 based indexing of positions
                long h2 = getHash(mid,i+len-1,hash,power);
                if (h1==h2) set.add(h1);
            }
        }

        return set.size();
    }

    private long getHash(int l, int r, long[] hash, long[] pow) {
        if (l == 0) return hash[r];
        return (hash[r]-(hash[l-1]*pow[r-l+1])%mod+mod)%mod;//r-l+1 = size of the substring, for equalizing the powers before subtraction
    }
}