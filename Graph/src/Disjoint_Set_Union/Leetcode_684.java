package Disjoint_Set_Union;


import java.util.Arrays;

public class Leetcode_684 {
    public static void main(String[] args) {
        Leetcode_684 app = new Leetcode_684();
        int[][] edges = {{1,2},{1,3},{2,3}};
        System.out.println("cycle edge : "+ Arrays.toString(app.findRedundantConnection(edges)));
    }
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet dsu = new DisjointSet(edges.length);
        int[] cycleEdge = new int[]{-1,-1};
        for (int[] edge : edges) {// if both nodes of the edge in same group, this is the cycle edge
            int u = edge[0],v = edge[1];
            if (dsu.union(u-1,v-1)) cycleEdge = new int[]{u,v};//1 based nodes
        }
        return cycleEdge;
    }

    static class DisjointSet{
        private int[] parent,rank;

        public DisjointSet(int n) {
            parent = new int[n];    rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i; //assign self as parent
        }
        public int find(int x){
            if (parent[x]==x) return x;//group leader found
            return parent[x] = find(parent[x]); //path compression
        }
        public boolean union(int x,int y){
            int px = find(x),py = find(y);
            if (px==py) return true;//cycle edge found

            if(rank[px]>rank[py])   parent[py] = px;//make the high rank parent
            else if (rank[py]>rank[px]) parent[px] = py;
            else { parent[py] = px; rank[px]++; }

            return false;
        }
    }
}