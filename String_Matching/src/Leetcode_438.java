import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_438 {
    public static void main(String[] args) {
        Leetcode_438 app = new Leetcode_438();
//        String s = "cbac", p = "abc";
        String s = "cbaebabacd", p = "abc";
        System.out.println("Anagram indices : "+app. findAnagrams(s,p));
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams=new ArrayList<>();
        char[] sLetters = s.toCharArray();
        char[] pLetters = p.toCharArray();
        Map<Character,Integer> pFreqMap = new HashMap<>();
        for (char cp : pLetters)
            pFreqMap.put(cp, pFreqMap.getOrDefault(cp,0)+1);

        int i=0,j=0, misMatch = pFreqMap.size();
        while (j<sLetters.length){
            if (pFreqMap.containsKey(sLetters[j])){//resolve from right(j)
                pFreqMap.put(sLetters[j], pFreqMap.get(sLetters[j])-1);
                if (pFreqMap.get(sLetters[j])==0)//conflict resolved for one letter
                    misMatch--;
            }

            if (j-i+1<p.length())
                j++;
            else if (j-i+1==p.length()){
                if (misMatch==0) //all conflict resolved
                    anagrams.add(i);

                if (pFreqMap.containsKey(sLetters[i])){//conflict from left(i)
                    pFreqMap.put(sLetters[i],pFreqMap.getOrDefault(sLetters[i],0)+1);
                    if (pFreqMap.get(sLetters[i])==1)//new letter, reduction from the left, mismatch will increase
                        misMatch++;
                }
                i++;    j++;
            }
        }
        return anagrams;
    }
}