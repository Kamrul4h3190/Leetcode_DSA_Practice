package DFS_BFS_Basic_Graphs;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_207 {
    public static void main(String[] args) {
        Leetcode_207 app = new Leetcode_207();
        int numCourses = 3;int[][] prerequisites = {{1,0},{2,1},{0,2}};
        System.out.println("can finish all course : "+app.canFinish(numCourses,prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;

        List<List<Integer>> graph = new ArrayList<>();//build directed graph
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] preq : prerequisites) graph.get(preq[1]).add(preq[0]);//u->v

        int [] visited = new int[numCourses];//loop detection 3 color dfs
        for (int i = 0; i < numCourses; i++)//explore if can finish all the courses. why not a single dfs ? Graph may be disconnected, so check from all nodes
            if (visited[i]==0 && !dfs(i,graph,visited)) return false;

        return true;
    }
    private boolean dfs(int source,List<List<Integer>> graph,int[] visited){
        if (visited[source]==2) return true;//completed all courses starting from source
        if (visited[source]==1) return false;//loop

        visited[source] = 1;//visited
        for (int neighbor: graph.get(source))
            if (!dfs(neighbor,graph,visited))
                return false;

        visited[source] = 2;//completely explored
        return true;
    }
}