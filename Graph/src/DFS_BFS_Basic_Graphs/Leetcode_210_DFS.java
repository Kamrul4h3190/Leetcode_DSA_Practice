package DFS_BFS_Basic_Graphs;


import java.util.*;

public class Leetcode_210_DFS {
    public static void main(String[] args) {
        Leetcode_210_DFS app = new Leetcode_210_DFS();
        int[][] prerequisites = {{0,1},{1,0}}; int numCourses = 2;//cycle
//        int[][] prerequisites = {{0,1}}; int numCourses = 2;
//        int[][] prerequisites = {{1,0}}; int numCourses = 2;
//        int[][] prerequisites = {{1,0}, {2,0}, {3,1},{3,2}}; int numCourses = 4; // 0 2 1 3
        System.out.println("course order : "+ Arrays.toString(app.findOrder(numCourses, prerequisites)));
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 1 ) return new int[]{0};
        List<List<Integer>> graph = buildGraph(prerequisites, numCourses);

        order = new Stack<>();    visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (!dfs(i,graph)) return new int[]{}; //cycle from any node

        int[] serial = new int[numCourses];
        for (int i = 0; i < numCourses; i++)    serial[i] = order.pop();
        return serial;
    }
    Stack<Integer> order;   int[] visited;
    private boolean dfs(int u,List<List<Integer>> graph){
        if (visited[u]==2) return true;
        if (visited[u]==1) return false;
        visited[u] = 1;

        for (int v : graph.get(u))
            if (!dfs(v, graph)) return false;

        order.push(u);  visited[u] = 2;

        return true;
    }

    public List<List<Integer>> buildGraph(int[][] prerequisites,int numCourses){//pre->course,course ...
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        return graph;
    }
}