import java.util.Arrays;

public class Leetcode_983 {
    public static void main(String[] args) {
        Leetcode_983 app = new Leetcode_983();
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};int[] costs = {2,7,15};
//        int[] days = {1,4,6,7,8,20};int[] costs = {2,7,15};
        System.out.println("minimum cost ticket : "+app.mincostTickets(days,costs));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        memDayTickets = new int[n];
        Arrays.fill(memDayTickets,-1);

        return exploreTickets(0,n,days,costs);
    }

    int[] memDayTickets;
    int exploreTickets(int idx,int n,int[] days,int[] costs) {
        if (idx>=n) return 0;

        if (memDayTickets[idx]!=-1) return memDayTickets[idx];

        int o = idx; while (o < n && days[o] <= days[idx]-1+1) o++;
        int oneDay = costs[0] + exploreTickets( o,n,days,costs) ;

        int s = idx; while (s < n && days[s] <= days[idx]-1+7) s++;
        int sevenDay = costs[1] + exploreTickets( s,n,days,costs) ;

        int t = idx; while (t < n && days[t] <= days[idx]-1+30) t++;
        int thirtyDay = costs[2] + exploreTickets( t,n,days,costs) ;

        return memDayTickets[idx] = Math.min(oneDay,Math.min(sevenDay,thirtyDay));
    }
}