import java.util.ArrayList;
import java.util.List;

public class Leetcode_745 {
    public static void main(String[] args) {
//        String[] words = {"appte","bat","ate"};
        String[] words = {"apple","ape","mapple"};
        WordFilter app = new WordFilter(words);
        System.out.println("prefix and suffix found last index : "+app.f("ap","le"));
    }

    static class WordFilter {
        String[] words;
        TrieNode rootPrefix = new TrieNode();
        TrieNode rootSuffix = new TrieNode();
        public WordFilter(String[] words) {
            this.words = words;
            for (int i = 0; i < words.length; i++) //build forward and reverse word tries
                insert(rootPrefix,words[i], i);
            for (int i = 0; i < words.length; i++)
                insert(rootSuffix,reverse(words[i]) , i);
        }
        public int f(String pref, String suff) {
            List<Integer> prefixes = crawlPrefix(rootPrefix,pref);
            List<Integer> suffixes = crawlPrefix(rootSuffix,reverse(suff));
            if (prefixes==null || suffixes==null) return -1;//out of trie prefix/suffix search queries

            int i = prefixes.size()-1,j = suffixes.size()-1;
            while (i>=0 && j>=0){
                int ni = prefixes.get(i), nj = suffixes.get(j);
                if (ni==nj) return ni;

                if (ni>nj) i--;
                else j--;
            }
            return -1;
        }

        private List<Integer> crawlPrefix(TrieNode root, String prefix){
            for (char letter: prefix.toCharArray()){
                int index = letter-'a';
                if (root.children[index]!=null)
                    root = root.children[index];
                else return null;//prefix is not from given words dictionary
            }
            return root.wordIndices;
        }
        private void insert(TrieNode root, String word, int i) {
            for (char letter:word.toCharArray()){
                int index = letter-'a';
                if (root.children[index]==null)
                    root.children[index] = new TrieNode();

                root.children[index].wordIndices.add(i);
                root = root.children[index];
            }
        }
        private String reverse(String word){
            return new StringBuilder(word).reverse().toString();
        }
        class TrieNode {
            public TrieNode[] children;
            List<Integer> wordIndices;
            public TrieNode() {
                children = new TrieNode[26];
                wordIndices = new ArrayList<>();
            }
        }

    }
}