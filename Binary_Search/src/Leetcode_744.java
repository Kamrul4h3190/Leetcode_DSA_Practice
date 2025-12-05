import java.util.Arrays;

public class Leetcode_744 {
    public static void main(String[] args) {
        Leetcode_744 app = new Leetcode_744();
//        char[] letters = {'x','x','y','y'}; char target = 'z';
        char[] letters = {'c','f','j'}; char target = 'c';
//        char[] letters = {'c','f','j'}; char target = 'j';
        System.out.println("letter[upperBound] : "+ app.nextGreatestLetter(letters,target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if (target<letters[0] || target>=letters[n-1]) return letters[0];

        int right = upperBound(letters,target);
        return letters[right];
    }
    public int upperBound(char[] letters, char target) {
        int n = letters.length;
        int left=0; int right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (letters[mid]>target)//first occurrence > target . right boundary of a range
                right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}