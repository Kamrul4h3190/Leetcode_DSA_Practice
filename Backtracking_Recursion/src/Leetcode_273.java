public class Leetcode_273 {
    public static void main(String[] args) {
        Leetcode_273 app = new Leetcode_273();
        int num = 12305;
        System.out.println("amount(in words) : "+app.numberToWords(num));
    }
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return helper(num).trim(); //trims to prevent extra whitespaces
    }

    private String helper(int num) {

        if (num >= 1000000000) return (helper(num / 1000000000) + " Billion " + helper(num % 1000000000));
        if (num >= 1000000) return (helper(num / 1000000).trim() + " Million " + helper(num % 1000000));
        if (num >= 1000) return (helper(num / 1000).trim() + " Thousand " + helper(num % 1000));
        if (num >= 100) return (helper(num / 100) + " Hundred " + helper((num % 100)));
        if (num >= 20) return (tens[num / 10] + " " + helper(num % 10));
        return ones[num];
    }
}
