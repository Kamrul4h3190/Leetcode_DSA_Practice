import java.util.Arrays;

public class Leetcode_3093 {
    public static void main(String[] args) {
        Leetcode_3093 app = new Leetcode_3093();
        String[] wordsContainer = {"abcd","bcd","bcd","xbcd"}, wordsQuery = {"cd","bcd","xyz"};
//        String[] wordsContainer = {"abcd","bcd","xbcd"}, wordsQuery = {"cd","bcd","xyz"};
//        String[] wordsContainer = {"abcdefgh","poiuygh","ghghgh"}, wordsQuery = {"gh","acbfgh","acbfegh"};
        System.out.println(Arrays.toString(app.stringIndices(wordsContainer, wordsQuery)));
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        int minIndex = -1, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            if (word.length()<minLen) {
                minLen = word.length();
                minIndex = i;//track the first occurrence of minimum length
            }
            insert( reverse(word) ,i,root,wordsContainer );
        }

        int[] lcsIndices = new int[wordsQuery.length];  int i=0;
        for (String query : wordsQuery)
            lcsIndices[i++] = search(reverse(query),root,minIndex);
        return lcsIndices;
    }
    private void insert(String word,int i, TrieNode node, String[] container){
        for (char letter : word.toCharArray()){
            int index = letter-'a';
            if (node.children[index]==null)//new child
                node.children[index] = new TrieNode(i);

            node = node.children[index];
            if (container[i].length() < container[node.lcsIndex].length() )
                node.lcsIndex = i;//update with smaller length lcs
        }
    }
    private int search(String word, TrieNode root,int minIndex){
        if (root.children[word.charAt(0)-'a']==null) return minIndex;

        for (char letter : word.toCharArray()) {
            int index = letter-'a';
            if (root.children[index]!=null)
                root = root.children[index];
            else break;//stop after crawling down as much possible with matching characters
        }
        return root.lcsIndex;
    }
    private String reverse(String word){
        return new StringBuilder(word).reverse().toString();
    }
    class TrieNode {
        public TrieNode[] children;
        int lcsIndex = 0; //smallest, if tie earliest lcs index. 0 is for "" suffix
        public TrieNode() {
            children = new TrieNode[26];
        }
        public TrieNode(int lcsIndex) {
            this();
            this.lcsIndex = lcsIndex;
        }
    }
}