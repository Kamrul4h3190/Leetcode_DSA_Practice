package Disjoint_Set_Union;


import java.util.*;

public class Leetcode_1697 {
    public static void main(String[] args) {
        Leetcode_1697 app = new Leetcode_1697();
        int[][] edgeList = {{0,1,2},{1,2,4},{2,0,8},{1,0,16}},queries = {{0,1,2},{0,2,5}}; int n = 3;
        System.out.println("paths : "+ Arrays.toString(app.distanceLimitedPathsExist(n, edgeList, queries)));
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < queries.length; i++) queries[i] = new int[]{queries[i][0],queries[i][1],queries[i][2],i};

        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);//sort based on distance
        Arrays.sort(queries,(a,b)->a[2]-b[2]);

        int e = 0;  boolean[] roads = new boolean[queries.length];
        for (int[] query : queries) {//each query
            while (e < edgeList.length && edgeList[e][2] < query[2]) {//each edge
                dsu.union(edgeList[e][0], edgeList[e][1]);
                e++;
            }

            roads[query[3]] = dsu.find(query[0]) == dsu.find(query[1]);
        }

        return roads;
    }

    static class DisjointSet{
        private int[] parent,rank;

        public DisjointSet(int n) {
            parent = new int[n];    for (int i = 0; i < n; i++) parent[i] = i; //assign self as parent
            rank = new int[n];
        }
        public int find(int x){
            if (parent[x]==x) return x;//group leader found
            return parent[x] = find(parent[x]);
        }
        public void union(int x,int y){
            int px = find(x),py = find(y);
            if (px==py) return;//already in same group

            if(rank[px]>rank[py])   parent[py] = px;//make the high rank parent
            else if (rank[py]>rank[px]) parent[px] = py;
            else { parent[py] = px; rank[px]++; }
        }
    }
}