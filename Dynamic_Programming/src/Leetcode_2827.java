import java.util.Arrays;

public class Leetcode_2827 {
    public static void main(String[] args) {
        Leetcode_2827 app = new Leetcode_2827();
        int low = 10,high = 20, k = 3;
        System.out.println("good numbers within range : "+ app.numberOfBeautifulIntegers(low,high,k));
    }
    public int numberOfBeautifulIntegers(int low,int high,int k) {
        String numHigh = Integer.toString(high);    String numLow = Integer.toString(low-1);

        memStates = new Integer[numHigh.length()][2][2][1+10][1+10][k];
        int ansHigh = digitDP(0,1,1,0,0,0,numHigh,k);

        memStates = new Integer[numLow.length()][2][2][1+10][1+10][k];//reset
        int ansLow = digitDP(0,1,1,0,0,0,numLow,k);

        return ansHigh-ansLow;
    }
    Integer[][][][][][] memStates;//position[],isTight[0/1],leadingZero[0/1],odds[11, for 10 digits],evens[11],rem[k]
    private int digitDP(int idx, int isTight,int isLdgZero,int odds,int evens,int rem, String number,int k){
        if (idx==number.length())   return odds==evens && rem==0 ? 1:0;

        if (memStates[idx][isTight][isLdgZero][odds][evens][rem]!=null) return memStates[idx][isTight][isLdgZero][odds][evens][rem];

        int ub = isTight==1 ? number.charAt(idx)-'0' : 9;
        int beautiful = 0;
        for (int digit = 0; digit <= ub; digit++) {
            int nextTight = isTight==1 && digit==ub ? 1:0;
            int nextRemainder = (rem*10+digit)%k;
            if (isLdgZero==1 && digit==0) //handle leading zero case separately
                beautiful+= digitDP(idx+1, 0, 1, 0, 0, 0, number,k);
            else {
                if ((digit&1)==0)//digit even
                    beautiful+= digitDP(idx+1, nextTight, 0, odds, evens+1, nextRemainder, number,k);
                else//digit odd
                    beautiful+= digitDP(idx+1, nextTight, 0, odds+1, evens, nextRemainder, number,k);
            }

        }
        return memStates[idx][isTight][isLdgZero][odds][evens][rem] = beautiful;
    }

}