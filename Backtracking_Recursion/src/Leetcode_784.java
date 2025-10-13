import java.util.ArrayList;
import java.util.List;

public class Leetcode_784 {
    public static void main(String[] args) {
        Leetcode_784 app = new Leetcode_784();
        String s = "a1b2";
        System.out.println("permutations : "+app.letterCasePermutation(s));
    }
    public List<String> letterCasePermutation(String S) {
        List<String> permutations = new ArrayList<>();
        char[] letters = S.toCharArray();
        permute(0 ,letters , permutations);
        return permutations;
    }
    private void permute(int i , char[] letters , List<String> permutations){
        if(i == letters.length) { permutations.add(new String(letters));  return;}

        char letter = letters[i];
        if (!Character.isDigit(letter)){
            letters[i] = Character.toUpperCase(letter); //transform, backtrack for lower case
            permute(i+1, letters, permutations);

            letters[i] = Character.toLowerCase(letter); //transform, backtrack for upper case
            permute(i+1, letters, permutations);
        }
        else permute(i+1, letters, permutations);//digits no choice just proceed/
    }
}

