package Disjoint_Set_Union;


public class Leetcode_1562 {
    public static void main(String[] args) {
        Leetcode_1562 app = new Leetcode_1562();
        int[] arr = {3,5,1,2,4}; int m = 1;
        System.out.println("latest step : " + app.findLatestStep(arr,m));
    }
    int[] parent, nodeGroupSize, sizeCount, bits;
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        parent = new int[n + 1]; //1 based
        nodeGroupSize = new int[n + 1];
        sizeCount = new int[n + 1];
        bits = new int[n + 2];//boundary check

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            nodeGroupSize[i] = 1;
        }

        int ans = -1;
        for (int i=1; i<=n; i++) {
            int node = arr[i-1]; //get the bit number. given arr is 0 based,node's are 1 based
            bits[node] = 1;     sizeCount[1]++; //set the bit and count[1]++;

            if (bits[node-1]==1) union(node,node-1);
            if (bits[node+1]==1) union(node,node+1);

            if (sizeCount[m]>0) ans = i;
        }
        return ans;
    }

    public int find(int u) {
        if (u == parent[u]) return u;
        return find(parent[u]);
    }

    public void union(int u, int v) {
        int pu = find(u),pv = find(v);  //find parents of u,v
        if (pu==pv) return; //already in same group

        sizeCount[nodeGroupSize[pu]]--;//reduce group size count for u,v
        sizeCount[nodeGroupSize[pv]]--;

        parent[pv] = pu;//update parent and sizeCount of new sized group
        nodeGroupSize[pu] += nodeGroupSize[pv];

        sizeCount[nodeGroupSize[pu]]++;
    }

}