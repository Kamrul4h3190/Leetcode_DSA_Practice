import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_229 {
    public static void main(String[] args) {
        Leetcode_229 app = new Leetcode_229();
        int[] nums = {3,2,3};
        System.out.println("majority element : "+app.majorityElement(nums));
    }
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> freqMap = new HashMap<>(); //<number,freq>
        for (int num : nums)//build map
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);

        List<Integer> mes = new ArrayList<>();
        int n = nums.length;
        int meThreshold = Math.floorDiv(n,3);//search for more than threshold freq element
        for (Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            if (entry.getValue()>meThreshold)
                mes.add(entry.getKey());
        }
        return mes;
    }
}