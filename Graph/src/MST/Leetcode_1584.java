package MST;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode_1584 {
    public static void main(String[] args) {
        Leetcode_1584 app = new Leetcode_1584();
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,10}};
        System.out.println("MST cost : " + app.minCostConnectPoints(points));
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<List<int[]>> graph = buildDenseGraph(points,n);
        return primsMST(graph,n);
    }
    private int primsMST(List<List<int[]>> graph,int n){
        boolean[] takenNode = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]); //(Node,distance)

        int minCost = 0;    minHeap.offer(new int[]{0,0});
        while (!minHeap.isEmpty()){
            int[] uNode = minHeap.poll();
            int u = uNode[0], du = uNode[1];
            if (takenNode[u]) continue;

            minCost += du;   takenNode[u] = true;

            for (int[] vNode : graph.get(u)) {
                int v = vNode[0], dv = vNode[1];
                if(!takenNode[v])   minHeap.offer(new int[]{v,dv});
            }
        }

        return minCost;
    }
    private List<List<int[]>> buildDenseGraph(int[][] points,int n){ //all nodes connected with all nodes
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int x1 = points[i][0], x2 = points[j][0];
                int y1 = points[i][1], y2 = points[j][1];
                int d = Math.abs(x1-x2) + Math.abs(y1-y2);

                adjList.get(i).add(new int[]{j,d});//u->{(v,dis),(v1,dis1),......}
                adjList.get(j).add(new int[]{i,d});//vice versa
            }
        }

        return adjList;
    }
}