public class Leetcode_371 {
    public static void main(String[] args) {
        Leetcode_371 app = new Leetcode_371();
        int a = 2,b=3;
        System.out.println("sum : "+app.getSum(a,b));
    }
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) { //while there is carry
            int a1 = a;//preserve the original value of a
            a = a1^b;//addition without carry
            b = (a1 & b) << 1;//shifted carry
        }
        return a;
    }
}
