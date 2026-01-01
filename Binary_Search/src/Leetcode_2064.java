public class Leetcode_2064 {
    public static void main(String[] args) {
        Leetcode_2064 app = new Leetcode_2064();
//        int[] quantities = {11,6}; int n = 6;
//        int[] quantities = {15,10,10}; int n = 7;
        int[] quantities = {100000}; int n = 1;
        System.out.println("minimized max : "+app.minimizedMaximum(n,quantities));
    }
    public int minimizedMaximum(int n,int[] quantities) {
        int left = 1;   int right = 0;
        for (int num : quantities) right = Math.max(right,num);

        while(left<right)
        {
            int mid = left+(right-left)/2;
            if(partitionPossible(mid, n,quantities))
                right = mid;
            else
                left=mid+1;
        }
        return left; //right also works
    }
    private boolean partitionPossible(int mid, int n,int[] quantities)
    {
        int stores = 0;
        for (int qty : quantities) {
            stores+= Math.ceilDiv(qty,mid);
            if (stores>n) return false;
        }
        return true;
    }
}