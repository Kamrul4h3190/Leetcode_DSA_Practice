import java.util.Arrays;

public class Leetcode_676 {
    public static void main(String[] args) {
        MagicDictionary app = new MagicDictionary();
        String[] dict = {"hallo", "hello"}; ;String query = "hello";
//        String[] dict = {"hello", "leetcode"}; ;String query = "hhllo";
//        String[] dict = {"hello", "leetcode"}; ;String query = "leetcoded";
        app.buildDict(dict);
        System.out.println(app.search(query));
    }

    static class MagicDictionary {
        TrieNode root;
        public MagicDictionary() {
            root = new TrieNode();
        }
        public void buildDict(String[] dictionary) {
            for (String word : dictionary)
                root.insert(word);
        }

        public boolean search(String query) {
            int n = query.length();
            char[] qArr = query.toCharArray();
            for (int i = 0; i < n; i++) {//for each positions
                for (char option = 'a'; option <= 'z'; option++) {//try all possible mismatching options
                    if (qArr[i]!=option){//found first mismatch, try with option
                        char original = qArr[i];
                        qArr[i] = option;
                        if (root.exactSearch(new String(qArr)))
                            return true;
                        qArr[i] = original;//backtrack for exploring next options
                    }
                }
            }

            return false;
        }


        class TrieNode {
            public TrieNode[] children;
            boolean wordEnd;
            public TrieNode() {children = new TrieNode[26];}
            private void insert(String word) {
                TrieNode root = this;
                for (char letter:word.toCharArray()){
                    int index = letter-'a';
                    if (root.children[index]==null)
                        root.children[index] = new TrieNode();

                    root = root.children[index];
                }
                root.wordEnd = true;
            }
            public boolean exactSearch(String query) {
                TrieNode root = this;
                for (char letter : query.toCharArray()) {
                    int index = letter-'a';
                    if (root.children[index]==null) return false;
                    root = root.children[index];
                }
                return root.wordEnd;
            }
        }
    }
}