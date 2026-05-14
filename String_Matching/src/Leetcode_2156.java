import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode_2156 {
    public static void main(String[] args) {
        Leetcode_2156 app = new Leetcode_2156();
        String s = "fbxzaad";int power = 31, modulo = 100, k = 3, hashValue = 32;
//        String s = "121345";int power = 10, modulo = (int) (1e9+7), k = 3, hashValue = 431;
//        String s = "leetcode";int power = 7, modulo = 50, k = 2, hashValue = 0;
//        String s = "leetcode";int power = 7, modulo = 20, k = 2, hashValue = 0;
        System.out.println("substring with given hash :"+app.subStrHash(s,power,modulo,k,hashValue));
    }
    public String subStrHash(String s, int p, int m, int k, int hashValue) {
        long hash = 0,power_k = 1;//the hash formula and given hashValue is reversed
        int n = s.length();
        int found = 0;
        for (int i = n-1; i >=0; i--) {//generate reverse hash from backward
            hash = (hash*p + (s.charAt(i)-'a'+1) )%m;//reverse number generation
            if (i<n-k)//K size out, reduce hash
                hash = (hash- (s.charAt(i+k)-'a'+1)*power_k%m + m)%m;
            else //else increase K's power which will be used to reduce hash
                power_k = power_k*p %m;

            if (hash == hashValue) found = i;//can not return immediately, because leftmost occurrence is the answer
        }
        return s.substring(found,found+k);
    }

    //numeric implementation
    /*public String subStrHash(String s, int p, int m, int k, int hashValue) {
        long cur = 0, pk = 1;
        int res = 0, n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            cur = (cur * p + s.charAt(i) - '0') % m;
            if (i<s.length()-k)
                cur = (cur - (s.charAt(i + k) - '0' ) * pk % m + m) % m;
            else
                pk = pk * p % m;
            if (cur == hashValue)
                res = i;
        }
        return s.substring(res, res + k);
    }*/
}