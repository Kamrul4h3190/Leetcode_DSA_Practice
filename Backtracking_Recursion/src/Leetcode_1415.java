import java.util.ArrayList;
import java.util.List;

public class Leetcode_1415 {
    public static void main(String[] args) {
        Leetcode_1415 app = new Leetcode_1415();
        int n = 3, k=2;
//        int n = 3, k=9;
        System.out.println("K th happy string : "+app.getHappyString(n,k));
    }
    public String getHappyString(int n, int k) {
        happyStrings = new ArrayList<>();   happy = "";     kthHappy="";     kth = k;
//        permutation(n,k-1);
//        if (k <= happyStrings.size()) return happyStrings.get(k-1); //1 indexed k;
//        return "";
//        return permutation(n,k);

        permutation(n);
        return kthHappy;
    }
    List<String> happyStrings;  String happy, kthHappy;
//    void permutation(int n){ //generate all permutaions
//        if (n==0)   {happyStrings.add(happy);    return;}
//
//        for (char letter = 'a'; letter<= 'c'; letter++){
//            if (!happy.isEmpty() && happy.charAt(happy.length()-1)==letter) continue; //discard same adjacents;
//            happy = happy + letter;
//            permutation(n-1);
//            happy = happy.substring(0,happy.length()-1);
//        }
//    }
    int kth;
    void permutation(int n){//early stop
        if (n==0)  {
            kth--;
            if (kth==0) kthHappy = happy;
            return;
        }

        for (char letter = 'a'; letter<= 'c'; letter++){
            if (!happy.isEmpty() && happy.charAt(happy.length()-1)==letter) continue; //discard same adjacents;
            happy = happy + letter;
            permutation(n-1);

            if (!kthHappy.isEmpty()) break;

            happy = happy.substring(0,happy.length()-1);
        }

    }
}

