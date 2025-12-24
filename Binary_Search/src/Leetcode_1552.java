import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_1552 {
    public static void main(String[] args) {
        Leetcode_1552 app = new Leetcode_1552();
        int[] positions = {1,2,3,4,7}; int m = 3;
        System.out.println("maximum robots within budget : "+app.maxDistance(positions,m));
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length-1]-position[0];
        while(left<=right)
        {
            int mid = left+(right-left)/2;
            if(canWePlace(position, mid, m))
                left=mid+1;
            else
                right = mid-1;
        }
        return right;
    }
    private boolean canWePlace(int[] arr, int minDist, int m)
    {
        int cntBalls=1;
        int lastPosition = arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]-lastPosition>=minDist) {
                cntBalls++;
                if(cntBalls>=m) return true;
                lastPosition = arr[i];
            }
        }
        return false;
    }
}