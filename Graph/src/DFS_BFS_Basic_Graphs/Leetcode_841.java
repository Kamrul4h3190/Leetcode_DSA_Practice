package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.List;

public class Leetcode_841 {
    public static void main(String[] args) {
        Leetcode_841 app = new Leetcode_841();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(List.of(1,3)));
        rooms.add(new ArrayList<>(List.of(3,0,1)));
        rooms.add(new ArrayList<>(List.of(2)));
        rooms.add(new ArrayList<>(List.of(0)));
        System.out.println("can visit all rooms : "+app.canVisitAllRooms(rooms));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0,rooms,visited);
        for (boolean visit : visited)
            if (!visit) return false;

        return true ;
    }
    private void dfs(int source,List<List<Integer>> rooms,boolean[] visited){
        visited[source] = true;
        for (int neighbor: rooms.get(source))
            if (!visited[neighbor])
                dfs(neighbor,rooms,visited);

    }
}