import java.util.HashMap;
import java.util.Map;

public class Leetcode_3045_v2 {
    public static void main(String[] args) {
        Leetcode_3045_v2 app = new Leetcode_3045_v2();
//        String[] words = {"pa","papa","ma","mama"};
        String[] words = {"a","aba","ababa","aa"};
        System.out.println("prefix suffix pairs : "+app.countPrefixSuffixPairs(words));
    }
    public long countPrefixSuffixPairs(String[] words) {
        TrieNode root = new TrieNode();
        long cnt = 0;
        for (String word : words) {
            cnt += findPairs(word, root);
            insert(word, root);
        }
        return cnt;
    }
    private void insert(String word, TrieNode node){
        int l = word.length();
        for (int i = 0; i < l; i++) {
            int j = (l-1)-i;
            int key = word.charAt(i)*128 + word.charAt(j);
            node.child.putIfAbsent(key, new TrieNode());
            node = node.child.get(key);
        }
        node.count++;
    }
    private long findPairs(String word, TrieNode node){
        long pairs = 0;     int l = word.length();
        for (int i = 0; i < l; i++) {
            int j = (l-1)-i;
            int key = word.charAt(i)*128 + word.charAt(j);
            if (!node.child.containsKey(key)) break;

            node = node.child.get(key);
            pairs += node.count;
        }
        return pairs;
    }


    class TrieNode {
        Map<Integer, TrieNode> child = new HashMap<>();
        int count = 0;//count number of prefix suffix pairs
    }
}