public class Leetcode_233 {
    public static void main(String[] args) {
        Leetcode_233 app = new Leetcode_233();
        int n=824883294;
//        int n=23;
        System.out.println("number of 1,s upto n : "+ app.countDigitOne(n));
    }
    public int countDigitOne(int n) {
        if (n==0) return 0;

        String number = Integer.toString(n);
        memStates = new Integer[number.length()][2][number.length()];//idx,isTight,Count1s
        return digitDP(0,1,0,number);
    }
    Integer[][][] memStates;
    private int digitDP(int i, int tight, int count1s, String number){
        if (i==number.length()) return count1s;

        if (memStates[i][tight][count1s]!=null) return memStates[i][tight][count1s];

        int total1s = 0;
        int lb = 0;
        int up = tight==1 ? number.charAt(i)-'0' : 9;
        for (int digit = lb; digit <= up; digit++) {//pass custom parameters, not edit globally
            total1s += digitDP(i+1,  tight==1 && digit==up ? 1:0 , digit==1 ? 1+count1s: count1s , number);
        }
        return memStates[i][tight][count1s] = total1s;
    }
}