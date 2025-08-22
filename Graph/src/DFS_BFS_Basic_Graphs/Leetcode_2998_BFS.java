package DFS_BFS_Basic_Graphs;


import java.util.*;

public class Leetcode_2998_BFS {
    public static void main(String[] args) {
        Leetcode_2998_BFS app = new Leetcode_2998_BFS();
        int x=26,y=1;
        System.out.println("minimum operations : "+app.minimumOperationsToMakeEqual(x,y));
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(x == y) return 0;//works fine without . but this 2 line increases speed upto 80 %.
        if(x < y) return y-x; //if x is less difference with y is minimum transformation steps.

        int level=0;    HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);     visited.add(x);
        while (!queue.isEmpty()){
            int levelSize = queue.size();//bfs.visit each level wise from the queue
            for (int i = 0; i < levelSize; i++) {
                int num = queue.poll();
                if (num==y) return level;
                //enqueue possible bfs neighbors
                if (num%11==0 && !visited.contains(num/11)){
                    queue.add(num/11);
                    visited.add(num/11);
                }
                if (num%5==0 && !visited.contains(num/5)){
                    queue.add(num/5);
                    visited.add(num/5);
                }
                if (!visited.contains(num-1)){
                    queue.add(num-1);
                    visited.add(num-1);
                }
                if (!visited.contains(num+1)){
                    queue.add(num+1);
                    visited.add(num+1);
                }
            }
            level++;
        }
        return Integer.MAX_VALUE;//does not return here.just to indicate not possible to transform
    }
}