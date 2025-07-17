package BST.leetcode_1382;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {8,5,1,7,10,12};
        TreeNode root = TreeNode.bstFromPreorder(preorder);

        TreeNode balancedRoot = app.balanceBST(root);
        System.out.println("After balancing "+inOrder(balancedRoot,new ArrayList<>()));
    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> sorted = inOrder(root,new ArrayList<>());
        return sortedArrayToBST(0, sorted.size()-1, sorted);
    }
    private TreeNode sortedArrayToBST(int left,int right,ArrayList<Integer> sorted){
        if (left>right) return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(sorted.get(mid));

        root.left = sortedArrayToBST(left,mid-1,sorted);
        root.right = sortedArrayToBST(mid+1,right,sorted);

        return root;
    }

    static ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> sorted){//traversal function
        if (root==null) return null;

        inOrder(root.left,sorted);
        sorted.add(root.val);
        inOrder(root.right,sorted);

        return sorted;
    }
}
