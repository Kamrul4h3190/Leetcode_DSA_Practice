import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode_14 {
    public static void main(String[] args) {
        Leetcode_14 app = new Leetcode_14();
        String[] strs = {"ab","a"};
//        String[] strs = {"flower","flow","flight"};
        System.out.println("longest common prefix :"+app.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs,(a,b)->a.length()-b.length());
        Trie root = new Trie();
        StringBuilder prefix = new StringBuilder();
        for (String word : strs)
            insert(word,root);

        int len = 0;
        while (root.children.size()==1) {
            len++;
            root = root.next;
        }
        for (String word : strs) {
            if(word.length()<len)
                len = word.length();
        }

        String lastWord = strs[strs.length-1];
        return lastWord.isEmpty() ? "": lastWord.substring(0,len);
    }
    static class Trie {//utility classes are conventionally static
        Set<Character> children = new HashSet<>();
        Trie next;
        boolean isEnd = false;
    }
    void insert(String word, Trie root) {
        Trie cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.children.contains(ch)){
                cur.next = new Trie();
                cur.children.add(ch);
            }

            cur = cur.next;
        }
        cur.isEnd = true;
    }
}