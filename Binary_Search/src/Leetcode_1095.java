public class Leetcode_1095 {
    public static void main(String[] args) {
        Leetcode_1095 app = new Leetcode_1095();
        int[] nums = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;//this is an interface based problem.direct testing not possible
//        System.out.println("target found at : " + app.findInMountainArray(target,MountainArray));
    }

    public int findInMountainArray(int target, MountainArray mountain) {
        int peakIndex = peakIndexInMountainArray(mountain);
        int increasingIndex = searchAscending(target,0,peakIndex,mountain);
        if (mountain.get(increasingIndex) == target)
            return increasingIndex;
        //if not found in rising slope, search in dowm slope
        int decreasingIndex = searchDescending(target,peakIndex+1,mountain.length()-1,mountain);
        if (mountain.get(decreasingIndex) == target)
            return decreasingIndex;

        return -1;
    }
    private int peakIndexInMountainArray(MountainArray mountain) {
        int left = 0;
        int right = mountain.length() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountain.get(mid) > mountain.get(mid + 1))//we need the first occurrence of this condition
                right = mid-1;
            else left = mid + 1;
        }
        return left;
    }
    //tight bound search [(l<r) ,right = mid] can also be used. In those cases both case return left
    private int searchAscending(int target,int l,int r,MountainArray mountain) {
        while (l<=r){
            int mid = l+(r-l)/2;
            if (mountain.get(mid)==target) return mid;

            if (mountain.get(mid) < target)
                l=mid+1;
            else r = mid-1;
        }
        return l;
    }
    public int searchDescending(int target,int l,int r,MountainArray mountain) {
        while (l<=r){
            int mid = l+(r-l)/2;
            if (mountain.get(mid)==target) return mid;

            if (mountain.get(mid) < target)
                r = mid-1;
            else l=mid+1;
        }
        return r;//left may outbound
    }
}
interface MountainArray {
      public int get(int index);
      public int length();
}