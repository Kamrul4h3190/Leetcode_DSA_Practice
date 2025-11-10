import java.util.Arrays;

public class Leetcode_1092 {
    public static void main(String[] args) {
        Leetcode_1092 app = new Leetcode_1092();
        String str1 = "abac";
        String str2 = "cab";
        System.out.println("shortest common super sequence : "+app.shortestCommonSupersequence(str1,str2));
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        m=str1.length();n=str2.length();    memLCS = new String[m][n];

        String lcs = lcs(0,0,m,n,str1,str2);
        int i=0,j=0;
        String superSeq = ""; //superSeq(str1,str2) = (str1+str2)-lcs
        for (char l : lcs.toCharArray()) {
            //add non lcs chars to superSeq
            while (str1.charAt(i)!=l)
                superSeq+=str1.charAt(i++);
            while (str2.charAt(j)!=l)
                superSeq+=str2.charAt(j++);

            superSeq+=l; //add lcs chars once only
            i++;j++;
        }
        superSeq+=str1.substring(i);//append remaining str substrings
        superSeq+=str2.substring(j);
        return superSeq;
    }
    int m,n; String[][] memLCS;
    private String lcs(int i,int j,int m,int n,String str1,String str2){
        if (i>=m || j>=n) return "";
        if (memLCS[i][j]!=null) return memLCS[i][j];

        if (str1.charAt(i)==str2.charAt(j)) //matched, lcs will increase and forward both str
            return memLCS[i][j] = str1.charAt(i) + lcs(i+1, j+1, m, n, str1, str2);

        String proceed_i = lcs(i+1, j, m, n, str1, str2);
        String proceed_j = lcs(i, j+1, m, n, str1, str2);

        String largeLCS = proceed_i;
        if (proceed_j.length()>proceed_i.length()) largeLCS = proceed_j;
        return memLCS[i][j] = largeLCS;
    }
}