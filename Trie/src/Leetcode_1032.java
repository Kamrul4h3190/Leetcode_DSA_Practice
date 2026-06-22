import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_1032 {
    public static void main(String[] args) {
        String[] words = {"cd","c", "f", "kl"};
        StreamChecker app = new StreamChecker(words);
        System.out.println(app.query('c'));
        System.out.println(app.query('d'));
    }

    static class StreamChecker {
        TrieNode root = new TrieNode();
        StringBuilder stream = new StringBuilder();

        public StreamChecker(String[] words) {
            for (String word : words)
                root.insertReverse(word);
        }

        public boolean query(char letter) {
            stream.append(letter);
            return root.search(stream);
        }

        static class TrieNode {
            public TrieNode[] children;
            boolean wordEnd;
            public TrieNode() {
                children = new TrieNode[26];
            }
            private void insertReverse(String word) {
                TrieNode node = this;//node is local copy of root
                for (int i = word.length() - 1; i >= 0; i--) {
                    char c = word.charAt(i);
                    if (node.children[c - 'a'] == null)
                        node.children[c - 'a'] = new TrieNode();
                    node = node.children[c - 'a'];
                }
                node.wordEnd = true;
            }
            private boolean search(StringBuilder query) {
                TrieNode node = this;
                for (int i = query.length() - 1; i >= 0; i--) {
                    char c = query.charAt(i);
                    int index = c - 'a';
                    if (node.children[index] == null)
                        return false;

                    node = node.children[index];
                    if (node.wordEnd) return true;
                }
                return node.wordEnd;
            }
        }
    }

}