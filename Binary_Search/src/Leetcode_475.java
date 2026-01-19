import java.util.Arrays;

public class Leetcode_475 {
    public static void main(String[] args) {
        Leetcode_475 app = new Leetcode_475();
        int[] houses = {1,5},heaters = {10};
//        int[] houses = {1,5},heaters = {1,2};
//        int[] houses = {1,2,3,4},heaters = {1,4};
//        int[] houses = {1,2,3},heaters = {2};
//        int[] houses = {1,3,4,6,8},heaters = {1,5};
//        System.out.println("can cover with mid : "+ app.canCover(3,houses,heaters));
        System.out.println("minimum heaters : "+ app.findRadius(houses,heaters));
    }

    public int findRadius(int[] houses,int[] heaters) {
        Arrays.sort(houses);    Arrays.sort(heaters);
        int left = 0, right = Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        while (left <= right) {
            int mid = left + ((right-left) >> 1);
            if (canCover(mid,houses,heaters)) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return left;
    }
    private boolean canCover(int mid,int[] houses,int[] heaters){
        int i = 0;  int n = houses.length;
        for (int heater : heaters) {
            int leftHouse = heater - mid;
            if (leftHouse>houses[i]) break;
            int rightHouse = heater + mid;
            while (i<n && houses[i]<=rightHouse)
                i++;
            if (i>=n) return true;
        }
        return false;
    }
}