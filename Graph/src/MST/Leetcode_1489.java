package MST;


import java.util.*;

public class Leetcode_1489 {
    public static void main(String[] args) {
        Leetcode_1489 app = new Leetcode_1489();
        int[][] edges = {{0,1,1},{1,2,1},{0,2,1},{2,3,4},{3,4,2},{3,5,2},{4,5,2}};int n=6;
//        int[][] edges = {{0,1,1},{1,2,1},{2,3,1},{0,3,1}};int n=4;
//        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};int n=5;
        System.out.println("edges : " + app.findCriticalAndPseudoCriticalEdges(n,edges));
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            int[] edge = new int[]{edges[i][0],edges[i][1],edges[i][2],i};//before sorting preserve original indices
            edges[i] = edge;
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));//sort based on weight

        int mstwt = kruskalsMST(n, edges, -1, -1);// no skip, no mandatory take

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (kruskalsMST(n, edges, i, -1) > mstwt)//skip i th, no take
                critical.add(edges[i][3]);//the actual edge is at edges[i][3] , before sorting we preserved original indices here
            else if (kruskalsMST(n, edges, -1, i) == mstwt)//take i th, no skip
                pseudoCritical.add(edges[i][3]);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(critical);   result.add(pseudoCritical);
        return result;
    }

    private int kruskalsMST(int n, int[][] edges, int skipEdge, int takeEdge) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;     int connectedEdge=0;

        if (takeEdge != -1) {
            weight += edges[takeEdge][2];       connectedEdge++;
            uf.union(edges[takeEdge][0], edges[takeEdge][1]);
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skipEdge) continue;

            if (uf.find(edges[i][0]) != uf.find(edges[i][1])){//take was skipped successfully here as union done earlier
                uf.union(edges[i][0], edges[i][1]);
                weight += edges[i][2];      connectedEdge++;
            }
        }

        if (connectedEdge!=n-1) return Integer.MAX_VALUE;//all nodes not connected. Not MST

        return weight;
    }

    class UnionFind {
        int[] parent,rank;
        public UnionFind(int n) {
            parent = new int[n];    rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find (int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent == y_parent) return;

            if(rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else if(rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
        }
    }
}