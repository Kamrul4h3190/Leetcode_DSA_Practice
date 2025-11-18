import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode_131 {
    public static void main(String[] args) {
        Leetcode_131 app = new Leetcode_131();
        String s = "aabaa";
//        String s = "aab";
        System.out.println("palindrome substrings : " + app.partition(s));
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        List<String> t = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[n][n];
        computePalindromes(s, dp);
        backtrack(0, s, t, result, dp);
        return result;
    }

    HashMap<String, List<String>> memInsertions;

    private void backtrack(int i, String s, List<String> curr, List<List<String>> result, boolean[][] dp) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < s.length(); j++) { //Time- O(n*2^n)
            if (dp[i][j]) {
                curr.add(s.substring(i, j + 1));
                backtrack(j + 1, s, curr, result, dp);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private void computePalindromes(String s, boolean[][] dp) {
        int n = s.length();
        for (int len = 1; len <= n; len++) {
            for (int i = 0, j; i <= n - len; i++) {
                j = i + len - 1;
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (len <= 2 || dp[i + 1][j - 1]));
            }
        }
    }

}