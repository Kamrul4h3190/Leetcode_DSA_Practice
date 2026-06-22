import java.util.Arrays;

public class Leetcode_792 {
    public static void main(String[] args) {
        Leetcode_792 app = new Leetcode_792();
        String s = "abcde";String[] words = {"a","bb","acd","ace"};
        System.out.println("matching subsequences : "+ app.numMatchingSubseq(s,words));
    }
    public int numMatchingSubseq(String s, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words)
            root.insert(word);
        visitTrie(0,s,root);
        return count;
    }
    int count = 0;
    private void visitTrie(int s_idx,String s,TrieNode root){
        for (TrieNode child : root.children) {
            if (child==null) continue;

            int index = findChar(child.letter,s_idx,s);//find root letter in s
            if (index!=-1){
                count+=child.wordCount;
                visitTrie(index+1,s,child);
            }
        }
    }
    private int findChar(char c,int start,String s){
        for (int i = start; i < s.length(); i++)
            if (s.charAt(i)==c) return i;
        return -1;
    }

    class TrieNode {
        private TrieNode[] children;
        private char letter;
        private int wordCount = 0;
        public TrieNode() {children = new TrieNode[26];}

        private void insert(String word) {
            TrieNode node = this;//the local copy node is moving. not the global root
            for (char letter:word.toCharArray()){
                int index = letter-'a';
                if (node.children[index]==null)
                    node.children[index] = new TrieNode();

                node = node.children[index];
                node.letter = letter;
            }
            node.wordCount++;
        }
    }
}