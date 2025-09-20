package Disjoint_Set_Union;


import java.util.Arrays;

public class Leetcode_1319 {
    public static void main(String[] args) {
        Leetcode_1319 app = new Leetcode_1319();
        int[][] connections = {{0,1},{0,2},{1,2}}; int n = 4;
        System.out.println("min edge replacements : "+ app.makeConnected(n,connections));
    }
    public int makeConnected(int n,int[][] connections) {
        DisjointSet dsu = new DisjointSet(n);
        int e = connections.length;     if (e < n-1) return -1;

        int usedEdges = 0;
        for (int[] edge : connections) {// if both nodes of the edge in same group, this is the cycle edge
            int u = edge[0],v = edge[1];
            if (dsu.union(u,v)) usedEdges++;
        }
        return n-1-usedEdges;
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
            if (px==py) return false;//cycle edge found

            if(rank[px]>rank[py])   parent[py] = px;//make the high rank parent
            else if (rank[py]>rank[px]) parent[px] = py;
            else { parent[py] = px; rank[px]++; }

            return true;
        }
    }
}