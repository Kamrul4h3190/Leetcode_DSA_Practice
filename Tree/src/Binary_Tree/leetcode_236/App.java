package Binary_Tree.leetcode_236;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        App app = new App();    TreeNode treeBuilder = new TreeNode();
        int[] preorder = {3,5,6,2,7,4,1,0,8};int[] inorder = {6,5,7,2,4,3,0,1,8};
        TreeNode root = treeBuilder.buildTree(preorder,inorder);
        TreeNode p = treeBuilder.findNode(root,5);
        TreeNode q = treeBuilder.findNode(root,1);
        System.out.println("LCA : "+app.lowestCommonAncestor(root,p,q).val);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;
        if (root==p || root==q) return root;

        TreeNode findLeft = lowestCommonAncestor(root.left,p,q);
        TreeNode findRight = lowestCommonAncestor(root.right,p,q);

        if(findLeft!=null && findRight!=null) return root;//found in both side

        return (findRight==null) ? findLeft : findRight;//found in same side
    }
}