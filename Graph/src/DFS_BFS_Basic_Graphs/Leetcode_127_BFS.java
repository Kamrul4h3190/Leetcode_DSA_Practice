package DFS_BFS_Basic_Graphs;


import java.util.*;

public class Leetcode_127_BFS {
    public static void main(String[] args) {
        Leetcode_127_BFS app = new Leetcode_127_BFS();
        String beginWord = "hit",endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot","dot","dog","lot","log","cog"));
        System.out.println("minimum transformations : "+app.ladderLength(beginWord,endWord,wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<Character> chars = new HashSet<>();
        for (String word : wordSet) {
            for (char ch : word.toCharArray()) {
                chars.add(ch);
            }
        }

        Queue<String> queue = new LinkedList<>(); HashSet<String> visited = new HashSet<>();
        queue.offer(beginWord); visited.add(beginWord); int level = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();
                if(word.equals(endWord)) return  ++level;//words = level+1

                for (int s = 0; s < word.length(); s++) {//for each char in word
                    for (char ch : chars) {              // for each char from chars set
                        char[] wordChars = word.toCharArray();
                        wordChars[s] = ch;                //replace a char to get new valid word that lies in wordset
                        String nextWord = new String(wordChars);

                        if (!visited.contains(nextWord) && wordSet.contains(nextWord)){
                            queue.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}