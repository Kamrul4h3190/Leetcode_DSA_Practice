import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_1268_DFS {
    public static void main(String[] args) {
        Leetcode_1268_DFS app = new Leetcode_1268_DFS();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};String searchWord = "mouse";
        System.out.println("suggestions : "+app.suggestedProducts(products,searchWord));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for (String product: products) insert(root, product);

        List<List<String>> allSuggestion = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0,i+1);
            TrieNode joint = crawlToJoin(root,prefix);

            List<String> suggestion = dfs(joint,new StringBuilder(prefix), new ArrayList<>());
            allSuggestion.add(suggestion);
        }
        return allSuggestion;
    }
    private List<String> dfs(TrieNode node,StringBuilder word, List<String> words){
        if (node==null || words.size()==3) return words;

        if (node.wordEnd) words.add(word.toString());
        for (char letter = 'a';letter<='z'; letter++){
            int index = letter-'a';
            if (node.children[index]!=null){
                word.append(letter);
                dfs(node.children[index], word, words);
                word.deleteCharAt(word.length()-1);
            }
        }
        return words;
    }
    private TrieNode crawlToJoin(TrieNode node, String prefix){
        for (char letter : prefix.toCharArray()) {
            int index = letter-'a';
            if (node.children[index]!=null)
                node = node.children[index];
            else return null;
        }
        return node;
    }

    private void insert(TrieNode root, String word) {
        for (char letter:word.toCharArray()){
            int index = letter-'a';
            if (root.children[index]==null)
                root.children[index] = new TrieNode();
            root = root.children[index];
        }
        root.wordEnd=true;
    }
    static class TrieNode {
        public TrieNode[] children;
        boolean wordEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}