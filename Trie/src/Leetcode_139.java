import java.util.*;

public class Leetcode_139 {
    public static void main(String[] args) {
        Leetcode_139 app = new Leetcode_139();
        String s = "leetcode";String[] wordDict = {"leet","code"};
        System.out.println("word break possible :"+app.wordBreak(s, Arrays.stream(wordDict).toList()));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for (String word : wordDict)
            insert(word, root);

        dp = new Boolean[s.length()];
        return solve(s, root, 0);
    }
    Boolean[] dp;
    boolean solve(String s, Trie root, int start) {
        if (start == s.length()) return true;
        if (dp[start] != null) return dp[start];

        for (int i = start; i < s.length(); ++i) {
            String str = s.substring(start, i + 1);
            if ( search(str, root) && (solve(s, root, i + 1)) ) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }
    static class Trie {//utility classes are conventionally static
        Trie[] child = new Trie[26];
        boolean isEnd = false;
    }
    void insert(String word, Trie root) {
        Trie cur = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (cur.child[idx] == null)
                cur.child[idx] = new Trie();

            cur = cur.child[idx];
        }
        cur.isEnd = true;
    }

    boolean search(String word, Trie root) {
        Trie cur = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (cur.child[idx] == null)
                return false;

            cur = cur.child[idx];
        }
        return cur.isEnd;
    }
}