public class Leetcode_3045 {
    public static void main(String[] args) {
        Leetcode_3045 app = new Leetcode_3045();
        String[] words = {"a","aba","ababa","aa"};
        System.out.println("prefix suffix pairs : "+app.countPrefixSuffixPairs(words));
    }

    public long countPrefixSuffixPairs(String[] words) {
        long count = 0;
        TrieNode root = new TrieNode();
        for (String word : words) {
            count+= countPairs(word, root);
            insert(word,root);
        }
        return count;
    }
    private int countPairs(String word, TrieNode node){
        int count = 0;
        StringBuilder prefix = new StringBuilder();
        for (char letter : word.toCharArray()) {
            int index = letter-'a';
            prefix.append(letter);
            if (node.children[index]!=null)
                node = node.children[index];
            else break;//null

            if (node.wordEnded && word.endsWith(prefix.toString()) )
                count += node.wordCount;
        }
        return count;
    }
    private void insert(String word, TrieNode node){
        for (char letter : word.toCharArray()) {
            int index = letter-'a';
            if (node.children[index]==null)
                node.children[index] = new TrieNode();

            node = node.children[index];
        }
        node.wordEnded = true;
        node.wordCount++;
    }
    static class TrieNode {
        int wordCount;
        boolean wordEnded;
        TrieNode[] children = new TrieNode[26];
    }
}