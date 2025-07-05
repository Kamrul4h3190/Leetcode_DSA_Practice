import java.util.Arrays;

public class Leetcode_91 {
    public static void main(String[] args) {
        Leetcode_91 app = new Leetcode_91();
        String s = "2611055971756562";
//        String s = "1201234";
//        String s = "06";
//        String s = "12";
//        String s = "226";
        System.out.println("number of decoding ways : "+app. numDecodings(s));
    }
    public int numDecodings(String s) {
        int n=s.length();
        memWays = new int[n];
        Arrays.fill(memWays,-1);

        return dynamicDecode(0,n,s);
    }
    int[] memWays;
    private int dynamicDecode(int i,int n, String s){
        if (i>=n ) return 1;
        if (s.charAt(i)=='0') return 0;

        if (memWays[i]!=-1) return memWays[i];

        int oneDigit = dynamicDecode(i+1, n, s);;
        int twoDigit =(i+1<n && Integer.parseInt(s.substring(i,i+2))<=26) ?
                dynamicDecode(i+2, n, s) : 0;

        return memWays[i] = oneDigit+twoDigit;
    }
}