package Disjoint_Set_Union;


import java.util.Arrays;

public class Leetcode_924 {
    public static void main(String[] args) {
        Leetcode_924 app = new Leetcode_924();
        int[][] graph = {{1,1,1},{1,1,1},{1,1,1}};int[] initial = {1,2};
        System.out.println("malware min spread node : "+ app.minMalwareSpread(graph, initial));
    }
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;   DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j]==1)
                    ds.union(i,j);
            }
        }

        int[] infectedCount = new int[n];//in groups
        for (int infectedNode : initial){
            int parent = ds.find(infectedNode);
            infectedCount[parent]++;
        }

        Arrays.sort(initial);//sort to take the minimum index node in repeating same cases
        int removeNode = initial[0], maxInfected = 0; //at least this node will reduce 1 affected
        for (int infectedNode : initial){
            int parent = ds.find(infectedNode);
            if (infectedCount[parent]==1 && ds.size[parent] > maxInfected ){//the group with only 1 malware node. removing this node will minimize spread
                maxInfected = ds.size[parent];
                removeNode = infectedNode;
            }
        }
        return removeNode;
    }

    static class DisjointSet{
        private int[] parent, size;

        public DisjointSet(int n) {
            parent = new int[n];    for (int i = 0; i < n; i++) parent[i] = i; //assign self as parent
            size = new int[n];     for (int i = 0; i < n; i++) size[i] = 1;
        }
        public int find(int x){
            if (parent[x]==x) return x;//group leader found
            return parent[x] = find(parent[x]);
        }
        public void union(int x,int y){
            int px = find(x),py = find(y);
            if (px==py) return;//already in same group

            if(size[px]> size[py]) { parent[py] = px; size[px]+= size[py];}//make the grater size parent
            else if (size[py]> size[px]) {parent[px] = py;  size[py]+= size[px];}
            else { parent[py] = px; size[px]+= size[py];}
        }
    }
}