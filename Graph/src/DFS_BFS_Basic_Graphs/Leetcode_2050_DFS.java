package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.List;

public class Leetcode_2050_DFS {
    public static void main(String[] args) {
        Leetcode_2050_DFS app = new Leetcode_2050_DFS();
        int[][] relations = {{1,3},{2,3}}; int[] time = {3,2,5}; int n=3;
        System.out.println("max same color path : "+ app.minimumTime(n,relations,time));
    }
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();//build graph
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] course : relations) graph.get(course[1]-1).add(course[0]-1);//course->preq's. nodes are 1 based

        int totalCourseTime = 0;    int[] memMinCourseTime = new int[n];
        for (int i = 0; i < n; i++){
            int thisCourseTime = dfs(i,graph,time,memMinCourseTime);
            totalCourseTime = Math.max(totalCourseTime , thisCourseTime);
        }

        return totalCourseTime;
    }
    private int dfs(int u,List<List<Integer>> graph,int[] time,int[] memoization){ //DAG 2 color. memo array can handle visited[]
        if (memoization[u]!=0) return memoization[u];//previously computed minimum time for this course

        int longestPreq = 0;
        for (int v : graph.get(u)) {
            longestPreq = Math.max(longestPreq, dfs(v, graph, time, memoization) );
        }
        int courseTime = longestPreq + time[u];

        return memoization[u] = courseTime;
    }

}