import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode_524 {
    public static void main(String[] args) {
        Leetcode_524 app = new Leetcode_524();
        String s = "abpcplea"; List<String> dictionary = Arrays.asList(new String[]{"ale", "apple","applc", "monkey", "plea"});
//        String s = "abpcplea"; List<String> dictionary = Arrays.asList(new String[]{"ale", "apple", "monkey", "plea"});
        System.out.println("longest word : "+app.findLongestWord(s,dictionary));
    }
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
//        Collections.sort(dictionary);//sort words lexically, if same length, greater first
//        dictionary.sort((a, b) -> b.length() - a.length());
        for (String word : dictionary) {//try to form the first dictionary word from the S string
            int i = 0; int wordLen = word.length();
            for (char sLetter : s.toCharArray())
                if (i<wordLen && word.charAt(i) == sLetter) i++;
            if (i==wordLen) return word;
        }
        return "";
    }
}