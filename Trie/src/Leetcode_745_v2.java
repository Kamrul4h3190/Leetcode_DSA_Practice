import java.util.ArrayList;
import java.util.List;

public class Leetcode_745_v2 {
    public static void main(String[] args) {
//        String[] words = {"appte","bat","ate"};
        String[] words = {"apple","ape","applet"};
        WordFilter app = new WordFilter(words);
        System.out.println("prefix and suffix found last index : "+app.f("ap","let"));
    }

    static class WordFilter {
        String[] words;
        TrieNode root = new TrieNode();
        public WordFilter(String[] words) {
            this.words = words;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    String suffix = word.substring(j)+"{";
                    insert(root,suffix+word,i);
                }
            }
        }
        public int f(String pref, String suff) {
            return search(root, suff+"{"+pref);
        }
        private int search(TrieNode root, String word) {
            for (char letter:word.toCharArray()){
                int index = letter-'a';
                if (root.children[index]!=null)
                    root = root.children[index];
                else return -1;
            }
            return root.lastWordIndex;
        }
        private void insert(TrieNode root, String word, int i) {
            for (char letter:word.toCharArray()){
                int index = letter-'a';
                if (root.children[index]==null)
                    root.children[index] = new TrieNode();

                root.children[index].lastWordIndex = i;
                root = root.children[index];
            }
        }
        class TrieNode {
            public TrieNode[] children;
            int lastWordIndex = -1;
            public TrieNode() {
                children = new TrieNode[27];
            }
        }

    }
}