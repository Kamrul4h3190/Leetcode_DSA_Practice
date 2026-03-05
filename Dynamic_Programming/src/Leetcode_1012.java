public class Leetcode_1012 {
    public static void main(String[] args) {
        Leetcode_1012 app = new Leetcode_1012();
//        int n = 20;
        int n = 100;
//        int n = 99;
//        int n = 1000;
        System.out.println("total numbers containing duplicate digits : "+ app.numDupDigitsAtMostN(n));
    }
    public int numDupDigitsAtMostN(int n) {
        String number = Integer.toString(n);
        memStates = new Integer[number.length()][2][2][2][1<<10];
        return digitDP(0,1,0,1,0,number);
    }
    Integer[][][][][] memStates;//position[],digit[0-9],repeat[0/1],isTight[0/1],leadingZero[0/1]
    private int digitDP(int idx, int isTight,int isRepeat, int isLdgZero,int mask, String number){
        if (idx == number.length()) return isRepeat==1 ? 1:0;//found 1 ok number

        if (memStates[idx][isTight][isRepeat][isLdgZero][mask]!=null) return memStates[idx][isTight][isRepeat][isLdgZero][mask];

        int lb = 0;
        int ub = isTight==1 ? number.charAt(idx)-'0' : 9;
        int repeatNums = 0;
        for (int digit=lb; digit <= ub; digit++) {
            int nextTight = isTight==1 && digit==ub ? 1:0;
            int nextRepeat = isRepeat==1 || (1&mask>>digit)==1 ? 1:0;

            if (isLdgZero==1 && digit==0)// handle leading zero case separately
                repeatNums+= digitDP(idx+1, nextTight, 0, 1, mask, number);
            else
                repeatNums+= digitDP(idx+1, nextTight, nextRepeat, 0,mask|1<<digit, number);
        }
        return memStates[idx][isTight][isRepeat][isLdgZero][mask] = repeatNums;
    }
}