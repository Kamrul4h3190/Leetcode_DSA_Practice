public class Leetcode_2999 {
    public static void main(String[] args) {
        Leetcode_2999 app = new Leetcode_2999();
//        long start = 1,finish = 971; int limit = 9; String suffix = "72";
//        long start = 114,finish = 1864854501; int limit = 6; String suffix = "26";
        long start = 1114,finish = 1864854501; int limit = 7; String suffix = "26";
//        long start = 15,finish = 215; int limit = 6; String suffix = "10";
//        long start = 1,finish = 6000; int limit = 4; String suffix = "124";
//        long start = 1000,finish = 2000; int limit = 4; String suffix = "3000";
//        long fineNumbers = app.digitDP(0,1,limit,suffix, Long.toString(start));
        long fineNumbers = app.numberOfPowerfulInt(start,finish,limit,suffix);
        System.out.println("total powerfuls in range : "+ fineNumbers);
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String suffix) {
        this.limit = limit;
        this.suffix = suffix;

        memStates = new Long[Long.toString(finish).length()][2];
        long ansFinish = digitDP(0,true,Long.toString(finish));

        memStates = new Long[Long.toString(start).length()][2];
        long ansStart = digitDP(0,true,Long.toString(start-1));
        return ansFinish - ansStart;
    }
    private Long[][] memStates;
    private String suffix;
    private int limit;
    private long digitDP(int idx, boolean tight, String num) {
        if (Long.parseLong(suffix)>Long.parseLong(num)) return 0;
        if (idx == num.length()) return 1;
        if (memStates[idx][tight ? 1 : 0] != null) return memStates[idx][tight ? 1 : 0];

        long res = 0;
        int ub = tight ? num.charAt(idx) - '0':9;
        int suffixStart = num.length() - suffix.length();
        if (idx >= suffixStart) {//inside suffix
            int suffixIdx = idx - suffixStart;
            int suffixDigit = suffix.charAt(suffixIdx) - '0';
//            if (suffixDigit>ub) System.out.println("rejection at "+idx+": "+suffixDigit);
            if (suffixDigit <= ub){
//                System.out.println(idx+": "+suffixDigit);
                res += digitDP(idx + 1, tight && suffixDigit == ub, num);
            }
        }
        else { //normal case
            for (int digit = 0; digit <= Math.min(ub,limit); digit++) {
//                System.out.println(idx+": "+digit);
                res += digitDP(idx + 1, tight && digit == ub, num);
            }
        }
        return memStates[idx][tight ? 1 : 0] = res;
    }
}