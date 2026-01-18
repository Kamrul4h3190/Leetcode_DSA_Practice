import java.util.Arrays;

public class Leetcode_455 {
    public static void main(String[] args) {
        Leetcode_455 app = new Leetcode_455();
        int[] g = {10,9,8,7};  int[] s = {5,6,7,8};
//        int[] g = {1,2};  int[] s = {1,2,3};
//        int[] g = {1,2,3};  int[] s = {1,1};
        System.out.println("max satisfied kids : "+app.findContentChildren(g,s));
    }
    public int findContentChildren(int[] greed, int[] size) {
        Arrays.sort(greed); Arrays.sort(size);
        int gn = greed.length,sn = size.length;
        int gi = 0; int satisfied = 0;
        for (int si = 0;gi<gn && si <sn; si++) {
            if (size[si]>=greed[gi]){
                satisfied++;
                gi++;
            }
        }
        return satisfied;
    }
}