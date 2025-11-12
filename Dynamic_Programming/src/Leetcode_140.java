import java.util.*;

public class Leetcode_140 {
    public static void main(String[] args) {
        Leetcode_140 app = new Leetcode_140();
//        String s = "catsandog";List<String> wordDict = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
        String s = "catsanddog";List<String> wordDict = new ArrayList<>(Arrays.asList("cat","cats","and","sand","dog"));
        System.out.println("sentences : "+app.wordBreak(s,wordDict));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        mem = new HashMap<>();  dict = new HashSet<>(wordDict);
        return generateSentences(s);
    }
    Set<String> dict;   Map<String,List<String>> mem;
    private List<String> generateSentences(String s){
        if (s.isEmpty()) return new ArrayList<>(List.of(""));
        if (mem.containsKey(s)) return mem.get(s);

        List<String> allSentence = new ArrayList<>();
        for (String dictWord : dict) {
            if (s.startsWith(dictWord)){
                List<String> remainingSentences = generateSentences(s.substring(dictWord.length()));
                for (String sentence : remainingSentences) {
                    String newSentence = dictWord;
                    newSentence+=(sentence.isEmpty()) ?"" : " "+sentence;
                    allSentence.add(newSentence);
                }
            }
        }

        mem.put(s,allSentence);
        return allSentence;
    }
}