import java.util.Stack;

public class Leetcode_2375 {
    public static void main(String[] args) {
        Leetcode_2375 app = new Leetcode_2375();
        String pattern = "DDD";
//        String pattern = "IIIDIDDD";
        System.out.println("DI number : "+app.smallestNumber(pattern));
    }
    public String smallestNumber(String pattern) {
        number = "";
        segmentReverse(pattern);
        return number;
    }
    String number;  int digit=1;
    private void segmentReverse(String pattern){
        Stack<Integer> decreases = new Stack<>();
        int len = pattern.length();
        for ( int d = 0;d <= len; d++) {
            if (d==len){//last extra case
                if (pattern.charAt(len-1)=='D') decreases.push(digit++);
                else number += Integer.toString(digit);
                continue;
            }

            char dir = pattern.charAt(d);
            if (dir=='I'){ //if direction is increasing add to number string, else add to stack
                number += Integer.toString(digit++);

                while (!decreases.empty()) number += decreases.pop(); //if stack decreasing stack has numbers append them
            }else {
                decreases.push(digit++);
            }
        }

        while (!decreases.isEmpty()) number += decreases.pop();//if finishing sequence is decreasing, append decreasing numbers
    }
}
