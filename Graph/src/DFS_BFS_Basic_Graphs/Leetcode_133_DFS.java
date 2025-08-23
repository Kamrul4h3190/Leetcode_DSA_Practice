package DFS_BFS_Basic_Graphs;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_133_DFS {
    public static void main(String[] args) {
        Leetcode_133_DFS app = new Leetcode_133_DFS();
        int[][] adjList =   {{2,4},{1,3},{2,4},{1,3}};
        Node[]  nodes = new Node[adjList.length+1];//1 based
        for (int i = 1; i <= adjList.length; i++)   nodes[i] = new Node(i);

        Map<Node,List<Node>> graph = app.buildGraph(adjList,nodes);
        Node node = nodes[1]; //starting node
        Node clone = app.cloneGraph(node);
        app.showGraph(graph);
    }
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        Map<Node,Node> copyMap = new HashMap<>();
        return dfs(node,copyMap);
    }
    private Node dfs(Node node,Map<Node,Node> copyMap){
        if (copyMap.containsKey(node)) return copyMap.get(node);

        copyMap.put(node,new Node(node.val));
        for (Node neighbor : node.neighbors) {
            Node copy = dfs(neighbor,copyMap);
            copyMap.get(node).neighbors.add(copy);
        }
        return copyMap.get(node);
    }


    private Map<Node,List<Node>> buildGraph(int[][] adjList,Node[] nodes){
        Map<Node,List<Node>> graph = new HashMap<>();
        for (int i = 0; i < adjList.length; i++) {
            Node key = nodes[i+1];
            List<Node> neighbors = new ArrayList<>();
            for (int neighbor : adjList[i]) {
                neighbors.add(nodes[neighbor]);
            }
            key.neighbors = neighbors;
            graph.put(key,neighbors);
        }

        return graph;
    }

    private void showGraph(Map<Node,List<Node>> graph){
        for (Node key : graph.keySet()){
            System.out.print(key.val+" : ");
            for (Node neighbor : graph.get(key)) {
                System.out.print(neighbor.val+" ");
            }
            System.out.println();
        }
    }
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}