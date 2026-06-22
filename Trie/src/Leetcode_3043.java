public class Leetcode_3043 {
    public static void main(String[] args) {
        Leetcode_3043 app = new Leetcode_3043();
        int[] arr1 = {1,10,100}, arr2 = {1000};
        int len = app.longestCommonPrefix(arr1,arr2);
        System.out.println("length of lcs : "+len);
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        for (int num1 : arr1)
            insert(Integer.toString(num1),root);

        int maxLen = 0;
        for (int num2 : arr2) {
            maxLen = Math.max(maxLen, search(Integer.toString(num2), root));
        }
        return maxLen;
    }
    private int search(String word, TrieNode node){
        int len = 0;
        for (char letter : word.toCharArray()) {
            int index = letter-'0';
            if (node.children[index]!=null){
                len++;
                node = node.children[index];
            }
            else break;
        }
        return len;
    }
    private void insert(String word, TrieNode node){
        for (char letter : word.toCharArray()) {
            int index = letter-'0';
            if (node.children[index]==null)
                node.children[index] = new TrieNode();

            node = node.children[index];
        }
    }
    static class TrieNode {
        TrieNode[] children = new TrieNode[10];
    }
}