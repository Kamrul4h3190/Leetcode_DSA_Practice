import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode_600 {
    public static void main(String[] args) {
        Leetcode_600 app = new Leetcode_600();
//        int n = 20;
        int n = 6;
        System.out.println("binary numbers except consecutive 1s : "+ app.findIntegers(n));
    }
    public int findIntegers(int n) {
        String binary = Integer.toBinaryString(n);
//        String binary = getBinaryString(n);
        memStates = new Integer[binary.length()][2][2];
        return digitDP(0,0,1,binary);
    }
    Integer[][][] memStates;//position, prevBit, isTight
    private int digitDP(int bitIndex,int prevBit, int isTight, String binary){
        if (bitIndex == binary.length()) return 1;//found 1 ok number

        if (memStates[bitIndex][prevBit][isTight]!=null) return memStates[bitIndex][prevBit][isTight];

        int lb = 0;
        int ub = isTight==1 ? binary.charAt(bitIndex)-'0' : 1;
        int goodNumbers = 0;
        for (int bit=lb; bit <= ub; bit++) {
            if (prevBit==1 && bit==1) continue;//consecutive bit 1 found,we do not want these
            goodNumbers += digitDP(bitIndex+1, bit, isTight==1 && bit==ub ? 1:0, binary);//if previously tight and bit==upper bound ,next bit is tight, else not tight
        }

        return memStates[bitIndex][prevBit][isTight] = goodNumbers;
    }
    /*private String getBinaryString(int n){//manual binary string generation O(log^2(n))
        if (n==0) return "0";
        return getBinaryString(n/2)+n%2;
    }*/
}