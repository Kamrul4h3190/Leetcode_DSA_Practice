public class Leetcode_258 {
    public static void main(String[] args) {
        Leetcode_258 app = new Leetcode_258();
        int num = 38;
        System.out.println("single digit : "+app.addDigits(num));
    }
    public int addDigits(int num) {
        if(num==0) return 0;

        return (num%9==0) ? 9:num%9;
    }
}
