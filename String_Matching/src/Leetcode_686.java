import java.util.Arrays;

public class Leetcode_686 {
    public static void main(String[] args) {
        Leetcode_686 app = new Leetcode_686();
        String a = "abcd", b = "cdabcdab";
        System.out.println("minimum a repeats : "+app. repeatedStringMatch(a,b));
    }
    public int repeatedStringMatch(String a, String b) {
        StringBuilder a2= new StringBuilder();
        int repeatCount = 0;
        int d = Math.ceilDiv(b.length(),a.length());
        while (d-->0){
            a2.append(a);
            repeatCount++;
        }

        if (a2.toString().contains(b)) return repeatCount;

        a2.append(a);
        if (a2.toString().contains(b)) return repeatCount+1;

        return -1;
    }
}