import java.util.HashSet;
import java.util.Set;

public class Leetcode_1044 {
    public static void main(String[] args) {
        Leetcode_1044 app = new Leetcode_1044();
        String s = "banana";
//        String text = "abcabcabc";
        System.out.println("longest duplicate substring :"+app. longestDupSubstring(s));
    }

    public String longestDupSubstring(String s) {
        String lds = "";
        int left=1,right=s.length()-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            String str = rabinKarp(s,mid);
            if (!str.isEmpty()){
                lds = str;
                left = mid+1;
            }
            else right = mid-1;
        }
        return lds;
    }

    long base=27;
    private String rabinKarp(String s,int len){
        Set<Long> hashSet = new HashSet<>();
        long hash = getHash(s.substring(0,len));
        hashSet.add(hash);

        long pow = 1;
        for (int i = 1; i < len; i++) pow*=base;

        for (int i = 1; i <= s.length()-len; i++) {//rolling hash
            hash = getNextHash(hash,pow,s.charAt(i-1),s.charAt(i+len-1));
            if (hashSet.contains(hash))//duplicate substring found
                return s.substring(i,i+len);
            hashSet.add(hash);
        }
        return "";
    }
    private long getNextHash(long currHash, long powLeft, char leftChar, char rightChar){
        return(currHash - leftChar*powLeft)*base+rightChar;
    }
    private long getHash(String s){
        long hash = 0;
        long pow = 1;
        for (int i = s.length()-1; i >=0 ; i--) {//backward hash axp^4+bxp^3 + .....+ exp^0
            hash+= s.charAt(i)*pow; //power increasing from left to right
            pow*= base;
        }
        return hash;
    }
}