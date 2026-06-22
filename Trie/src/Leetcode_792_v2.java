import java.util.*;

public class Leetcode_792_v2 {
    public static void main(String[] args) {
        Leetcode_792_v2 app = new Leetcode_792_v2();
//        String s = "abcbde";String[] words = {"bb"};
        String s = "abcbe";String[] words = {"a","bb","acd","ace"};
//        String s = "abcde";String[] words = {"a","bb","acd","ace"};
        System.out.println("matching subsequences : "+ app.numMatchingSubseq(s,words));
    }
    public int numMatchingSubseq(String s, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words)
            root.insert(word);
        for (int i=0;i<s.length();i++) {
            char letter = s.charAt(i);
            if (!indicesMap.containsKey(letter))
                indicesMap.put(letter,new ArrayList<>());
            indicesMap.get(letter).add(i);
        }
        visitTrie(0,s,root);
        return count;
    }
    int count = 0;
    Map<Character,List<Integer>> indicesMap = new HashMap<>();
    private void visitTrie(int s_idx,String s,TrieNode root){
        for (TrieNode child : root.children) {
            if (child==null) continue;

            List<Integer> indices = indicesMap.get(child.letter);
            if (indices==null) continue;

            int index = findLetter(s_idx, indices);//find root letter in s
            if (index!=-1){
                count+=child.wordCount;
                visitTrie(index+1,s,child);
            }
        }
    }
    private int findLetter(int lowerBound, List<Integer> positions){
        int n = positions.size();
        int left = 0,right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if ((positions.get(mid))>=lowerBound)
                right = mid-1;
            else left = mid+1;
        }
        return left==n ? -1 : positions.get(left);
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