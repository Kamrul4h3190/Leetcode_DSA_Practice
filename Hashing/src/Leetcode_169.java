import java.util.*;

public class Leetcode_169 {
    public static void main(String[] args) {
        Leetcode_169 app = new Leetcode_169();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println("majority element : "+app.majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>(); //<number,freq>
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);

        int me = 0;    int n = nums.length;
        int meThreshold = Math.floorDiv(n,2);
        for (Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            if (entry.getValue()>meThreshold)
                me = entry.getKey();
        }
        return me;
    }
//    public int majorityElement(int[] nums) {
//        HashMap<Integer,Integer> freqMap = new HashMap<>();
//        int mc=0,me = 0;
//
//        for (int n : nums) {
//            if (!freqMap.containsKey(n)){
//                freqMap.put(n,1);
//            }else {
//                freqMap.put(n,freqMap.get(n)+1);
//            }
//            if (freqMap.get(n)>mc){
//                mc=freqMap.get(n);
//                me=n;
//            }
//        }
//        return me;
//    }
}