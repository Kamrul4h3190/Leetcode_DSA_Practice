import java.util.*;

public class Leetcode_677 {
    public static void main(String[] args) {
        MapSum mapSum  = new MapSum();
        mapSum.insert("a",3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("b",2);
        System.out.println(mapSum.sum("a"));
    }
    static class MapSum {
        TrieNode root;
        public MapSum() {
            root = new TrieNode();
        }
        public void insert(String key, int val) {
            TrieNode node = root;
            for (char letter:key.toCharArray()){
                int index = letter-'a';
                if (node.children[index]==null)
                    node.children[index] = new TrieNode();
                node = node.children[index];
            }
            node.wordValue = val;//set the terminal value of the ended word
        }

        public int sum(String prefix) {
            TrieNode node = root;
            for (char letter : prefix.toCharArray()) {
                int index = letter-'a';
                if (node.children[index]==null)//no prefix
                    return 0;
                node = node.children[index];//pass node to the next child
            }
            //after fully reaching prefix calculate all its children's terminal score sum;
            return dfs(node);
        }

        int dfs(TrieNode node){
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                if (node.children[i]!=null)
                    sum += dfs(node.children[i]);
            }
            return sum + node.wordValue;
        }

        static class TrieNode {
            TrieNode[] children = new TrieNode[26];  // Fixed array for a-z
            int wordValue;
        }
    }
}