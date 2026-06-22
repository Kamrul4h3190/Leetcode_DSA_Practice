import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_2416 {
    public static void main(String[] args) {
        Leetcode_2416 app = new Leetcode_2416();
        String[] words = {"abc","ab","bc","b"};
        System.out.println("prefix counts : "+ Arrays.toString(app.sumPrefixScores(words)));
    }

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words)
            insert(root,word);

        int[] prefixScore = new int[words.length];
        for (int i = 0; i < words.length; i++)
            prefixScore[i] = searchAndCountPrefixes(root, words[i]);
        return prefixScore;
    }
    private int searchAndCountPrefixes(TrieNode node,String word){//just like search operation
        int count = 0;
        for (char letter : word.toCharArray()) {
            int index = letter-'a';
            count += node.children[index].prefixCount;//null check not necessary ,as trie was prebuilt
            node = node.children[index];
        }
        return count;
    }
    private void insert(TrieNode root, String word) {
        for (char letter:word.toCharArray()){
            int index = letter-'a';
            if (root.children[index]==null)
                root.children[index] = new TrieNode();

            root.children[index].prefixCount++;
            root = root.children[index];
        }
    }
    static class TrieNode {
        public TrieNode[] children;
        int prefixCount=0;
        public TrieNode() {children = new TrieNode[26];}
    }
}