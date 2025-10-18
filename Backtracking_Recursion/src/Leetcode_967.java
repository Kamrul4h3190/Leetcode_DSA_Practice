import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_967 {
    public static void main(String[] args) {
        Leetcode_967 app = new Leetcode_967();
        int n=3,k=7;
        System.out.println("numbers : "+ Arrays.toString(app.numsSameConsecDiff(n, k)));
    }
    public int[] numsSameConsecDiff(int n, int k) {
        numbersList = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            generateNumbers(1,i, i ,n,k);

        int[] nums = new int[numbersList.size()];
        int i=0;    for (int num : numbersList) nums[i++] = num;
        return nums;
    }
    List<Integer> numbersList;
    private void generateNumbers(int digitPlace, int currDigit, int currNumber, int n, int k){
        if (digitPlace==n){ // n digit number formed, add this to result
            numbersList.add(currNumber);
            return;
        }

        int newDigit = currDigit + k;
        if (newDigit < 10)
            generateNumbers(digitPlace + 1, newDigit, currNumber*10 + newDigit , n, k);
        newDigit = currDigit - k;// backtrack

        if (k!=0 && newDigit>=0)
            generateNumbers(digitPlace + 1, newDigit, currNumber*10 + newDigit , n, k);
    }
}

