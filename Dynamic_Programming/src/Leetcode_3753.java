public class Leetcode_3753 {
    public static void main(String[] args) {
        Leetcode_3753 app = new Leetcode_3753();
        long num1= 120,num2 = 130;
//        System.out.println("check DP upto range : "+ app.digitDP(0,true,true,-1,-1,0,Long.toString(num1-1)));
        System.out.println("total waviness within range : "+ app.totalWaviness(num1,num2));
    }
    public long totalWaviness(long num1, long num2) {
        String num1Str = Long.toString(num1-1),   num2Str = Long.toString(num2);//starting range reduced -1 here

        memStates = new Long[num2Str.length()][2][2][1+10][1+10][16]; //1 extra as prev starts from -1
        Long ansNum2 = digitDP(0,true,true,-1,-1,0,num2Str);

        memStates = new Long[num1Str.length()][2][2][1+10][1+10][16]; //16 longs are 16 digits, or we can take numStr.len()
        Long ansNum1 = digitDP(0,true,true,-1,-1,0,num1Str);

        return ansNum2-ansNum1;
    }
    Long[][][][][][] memStates;//position,tight, ldgZero, prev2, prev1, wave
    private long digitDP(int idx, boolean tight,boolean ldgZero,int prev2,int prev1,int wave, String number){
        if (idx==number.length())   return !ldgZero ? wave:0;

        if (memStates[idx][tight?1:0][ldgZero?1:0][prev2+1][prev1+1][wave]!=null) return memStates[idx][tight?1:0][ldgZero?1:0][prev2+1][prev1+1][wave];

        int ub = tight ? number.charAt(idx)-'0' : 9;
        long totalWave = 0;
        for (int digit = 0; digit <= ub; digit++) {
            boolean nextTight = tight && digit==ub;
            boolean nextLdgZero = ldgZero && digit==0;
            if (ldgZero) //handle leading zero case separately
                totalWave+= digitDP(idx+1, nextTight, nextLdgZero, -1, digit,wave, number);
            else if (prev2==-1)
                totalWave+= digitDP(idx+1, nextTight, false, prev1, digit,wave, number);
            else {// core logic : keep track of previous 2 digits, and find whether a peak of valley has formed by the current digit
                int peakOrValley = (prev1>prev2 && prev1>digit) || (prev1<prev2 && prev1<digit) ? 1:0;
                totalWave+= digitDP(idx+1, nextTight, false, prev1, digit,wave+peakOrValley, number);
            }
        }
        return memStates[idx][tight?1:0][ldgZero?1:0][prev2+1][prev1+1][wave] = totalWave;
    }

}