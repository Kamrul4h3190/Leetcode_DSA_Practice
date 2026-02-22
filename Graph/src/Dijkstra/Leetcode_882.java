package Dijkstra;


import java.util.*;

public class Leetcode_882 {
    public static void main(String[] args) {
        Leetcode_882 app = new Leetcode_882();
        int[][]edges = {{0,1,10},{0,2,1},{1,2,2}};int maxMoves = 6,n = 3;
//        int[][]edges = {{0,1,10},{0,2,1},{1,2,2}};int maxMoves = 6,n = 3;
        System.out.println("reachable nodes : " + app.reachableNodes(edges,maxMoves,n));
    }

    public int reachableNodes(int[][] edges, int maxNodes, int n) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {//build undirected graph
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[]{u,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));//maxHeap. give the node with most remaining moves
        pq.offer(new int[] {0,maxNodes});
        HashMap<Integer, Integer> visited = new HashMap<>();//<node,remaining moves>
        while (!pq.isEmpty()) {
            int[] vNode = pq.poll();
            int v = vNode[0],vMoves = vNode[1];
            if (!visited.containsKey(v)){
                visited.put(v,vMoves);
                for (int[] uNode : graph.get(v)) {
                    int u = uNode[0],wu = uNode[1];
                    int uMoves = vMoves-(wu+1);//node+1 moves to reach a node
                    if (uMoves>=0) //add to queue if this node is reachable via um moves
                        pq.add(new int[]{u,uMoves});
                }
            }
        }
        int res = visited.size();//traverse through all edges and sum remaining moves from nodes
        for (int[] v : edges) {
            int a = visited.getOrDefault(v[0],0);
            int b = visited.getOrDefault(v[1],0);
            res += Math.min(a + b, v[2]);
        }
        return res;
    }
}