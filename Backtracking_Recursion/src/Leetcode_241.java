import java.util.*;

public class Leetcode_241 {
    public static void main(String[] args) {
        Leetcode_241 app = new Leetcode_241();
        String expression = "2*3-4*5";
        System.out.println("Expression bracket evaluations : "+app.diffWaysToCompute(expression));
    }
    public List<Integer> diffWaysToCompute(String expression) {
        memSubExps = new HashMap<>();
        return evaluate(0,expression.length(),expression);
    }
    Map<String,List<Integer>> memSubExps;
    private List<Integer> evaluate(int left,int right,String expression){
        String key = expression.substring(left,right);
        if (memSubExps.containsKey(key)) return memSubExps.get(key);

        List<Integer> expValues = new ArrayList<>();
        for (int i = left; i < right; i++) {
            if (expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*'){
                List<Integer> leftEvaluations = evaluate(left, i, expression);
                List<Integer> rightEvaluations =evaluate(i+1,right,expression);

                char operator = expression.charAt(i); //pair operands of both sides and do the operations
                for (int leftNumber : leftEvaluations) {
                    for (int rightNumber : rightEvaluations) {
                        if (operator=='+') expValues.add(leftNumber+rightNumber);
                        else if (operator=='-') expValues.add(leftNumber-rightNumber);
                        else  if (operator=='*') expValues.add(leftNumber*rightNumber);
                    }
                }
            }
        }

        if (expValues.isEmpty())    expValues.add(Integer.valueOf(expression.substring(left,right)));//expression reduced to a number, no operators. get that number to the operands list
        memSubExps.put(key,expValues);      return expValues;
    }
}
