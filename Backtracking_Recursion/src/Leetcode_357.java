public class Leetcode_357 {
    public static void main(String[] args) {
        Leetcode_357 app = new Leetcode_357();
        int n = 4;
        System.out.println("unique digit numbers : "+ app.countNumbersWithUniqueDigits(n));
    }
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        return calculateBottomUp(1, 10, 9,9,n);
    }
    //this is not a DP. rather divide and conquer. smaller solutions are building larger solutions
    private int calculateBottomUp(int d, int bottomUpTotal, int nDigitOptions, int options,int n) {
        if (d == n) return bottomUpTotal;

        int uniques = nDigitOptions * options;
        return bottomUpTotal + calculateBottomUp(d+1, uniques, uniques,options-1,n);
    }
}