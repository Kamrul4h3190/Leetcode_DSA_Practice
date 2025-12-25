import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode_354 {
    public static void main(String[] args) {
        Leetcode_354 app = new Leetcode_354();
        int[][] envelopes = {{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}};
//        int[][] envelopes = {{1,2},{2,3},{3,4},{5,6},{5,3},{5,2}};
//        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println("max russian dolls : "+app.maxEnvelopes(envelopes));
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        int n = envelopes.length;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++)
            heights[i] = envelopes[i][1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int h : heights){//in the list keep heights ascending
            int insertPosition = lowerBound(list, h);
            if(insertPosition < list.size())
                list.set(insertPosition, h);// place where this height should be
            else
                list.add(h);//all smaller , add at last
        }
        return list.size();
    }
    private int lowerBound(ArrayList<Integer> list, int target){
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}