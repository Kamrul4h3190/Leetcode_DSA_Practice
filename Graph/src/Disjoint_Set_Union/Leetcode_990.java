package Disjoint_Set_Union;


public class Leetcode_990 {
    public static void main(String[] args) {
        Leetcode_990 app = new Leetcode_990();
        String[] equations = {"b==a","a!=b"};
//        String[] equations = {"b!=a","a==b"};
//        String[] equations = {"b==a","a==b"};
        System.out.println("satisfy equations : "+ app.equationsPossible(equations));
    }
    public boolean equationsPossible(String[] equations) {
        DisjointSet dsu = new DisjointSet(26); // letters

        for (String eqn : equations) {// union for equality edges
            int u = eqn.charAt(0)-'a',v = eqn.charAt(3)-'a';
            if (eqn.charAt(1)=='=')     dsu.union(u,v);
        }

        for (String eqn : equations) {//checking unequal edges
            if (eqn.charAt(1)=='!'){
                int u = eqn.charAt(0)-'a',v = eqn.charAt(3)-'a';
                int pu = dsu.find(u), pv = dsu.find(v);
                if (pu == pv) return false; //they should be in different set. if in same set inequality not satisfied
            }
        }

        return true;
    }

    static class DisjointSet{
        private int[] parent,rank;

        public DisjointSet(int n) {
            parent = new int[n];    rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int x){
            if (parent[x]==x) return x;//group leader found
            return parent[x] = find(parent[x]); //path compression
        }
        public void union(int x,int y){
            int px = find(x),py = find(y);
            if (px==py) return;

            if(rank[px]>rank[py])   parent[py] = px;//make the high rank parent
            else if (rank[py]>rank[px]) parent[px] = py;
            else { parent[py] = px; rank[px]++; }
        }
    }
}