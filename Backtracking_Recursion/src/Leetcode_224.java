public class Leetcode_224 {
    public static void main(String[] args) {
        Leetcode_224 app = new Leetcode_224();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("value : "+app.calculate(s));
    }
    public int calculate(String s) {
        idx = 0;
        return evaluate(s);
    }
    int idx;
    private int evaluate(String s) {
         int result = 0,num = 0,sign = +1;
         while (idx<s.length()){
             char c = s.charAt(idx++);
             if (c>='0' && c<='9') num = num*10 + c-'0';//if digit build number
             else if (c=='(') num = evaluate(s); //new sub problem will give a new number, which will be added to previously calculated result
             else if (c==')') return result + sign*num;
             else if (c=='+' || c=='-'){ //a number has been formed earlier
                 result += sign*num;
                 num = 0;       //reset num and update sign for next operations
                 sign = c=='-'?-1 : +1;
             }
         }
         return result + sign*num;
    }
}
