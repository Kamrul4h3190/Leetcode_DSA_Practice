public class Leetcode_902_v2 {
    public static void main(String[] args) {
        Leetcode_902_v2 app = new Leetcode_902_v2();
//        String[] digits = {"1","4","9"};    int n = 1000000000;
        String[] digits = {"1","3","5","7"};    int n = 100;
        System.out.println("total nonzero numbers upto n : "+ app.atMostNGivenDigitSet(digits,n));
    }
    public int atMostNGivenDigitSet(String[] digits,int n) {
        String maxNumber = Integer.toString(n);
        memStates = new Integer[maxNumber.length()][2][2];
        for (String d : digits) digitsMask |= (1 << (Integer.parseInt(d))); //mark the allowed digits;
        return digitDp(0,1,1,maxNumber)-1;//-1, to exclude 0 from the count
    }
    Integer memStates[][][];//idx, isTight ,ldgZero
    int digitsMask = 0;
    private int digitDp(int idx, int isTight, int isLdgZero, String max_num){
        if (idx==max_num.length()) return 1;

        if (memStates[idx][isTight][isLdgZero]!=null) return memStates[idx][isTight][isLdgZero];

        int countNumbers = 0;
        int lb = 0;
        int ub = isTight==1 ? max_num.charAt(idx)-'0':9;
        for (int digit = lb; digit <= ub; digit++) {
            if (isLdgZero==1 && digit==0)
                countNumbers += digitDp(idx+1, 0, 1, max_num);
            else{
                if ((digitsMask>>digit&1)!=1 ) continue;//digit not allowed
                countNumbers += digitDp(idx+1, isTight==1 && digit==ub ? 1:0, 0, max_num);
            }
        }
        return memStates[idx][isTight][isLdgZero] = countNumbers;
    }
}