import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_1268 {
    public static void main(String[] args) {
        Leetcode_1268 app = new Leetcode_1268();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};String searchWord = "mouse";
        System.out.println("suggestions : "+app.suggestedProducts(products,searchWord));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product: products) insert(root, product);

        List<List<String>> results = new ArrayList<>();
        for (char c: searchWord.toCharArray()) {
            root = root.children[c - 'a'];//transfer root to the next char(c)
            if (root == null) break;
            results.add(root.getTopThree());
        }

        while (results.size() < searchWord.length())
            results.add(new ArrayList<>());
        return results;
    }

    private void insert(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null)
                root.children[c - 'a'] = new TrieNode();
            root = root.children[c - 'a'];
            root.addToPQ(word);//keep candidates at each trieNode
        }
    }
    static class TrieNode {
        public TrieNode[] children;
        public PriorityQueue<String> pq;
        public TrieNode() {
            children = new TrieNode[26];
            pq = new PriorityQueue<>((a,b) -> b.compareTo(a));//maxHeap. when oversizes, we need to delete the lexically largest word
        }
        public void addToPQ(String word) {
            pq.add(word);
            if (pq.size() > 3) pq.poll();
        }
        public List<String> getTopThree() {
            List<String> topThree = new ArrayList<>();
            while (!pq.isEmpty()) topThree.add(pq.poll());
            Collections.reverse(topThree);
            return topThree;
        }
    }
}