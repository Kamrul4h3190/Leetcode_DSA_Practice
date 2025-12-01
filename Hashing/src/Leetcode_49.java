import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_49 {
    public static void main(String[] args) {
        Leetcode_49 app = new Leetcode_49();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("anagrams grouped : "+app.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> groupMap = new HashMap<>();
        for (String word : strs) {
//            String key = generateKey(word);
            char[] letters = word.toCharArray();Arrays.sort(letters);
            String key = new String(letters);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());;
            }
            groupMap.get(key).add(word);
        }
        return  new ArrayList<>(groupMap.values()) ;
    }
}