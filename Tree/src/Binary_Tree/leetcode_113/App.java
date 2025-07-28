package Binary_Tree.leetcode_113;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        App app = new App();    TreeNode treeBuilder = new TreeNode();
        int[] preorder1 = {1,2,2};int[] inorder1 = {2,1,2}; int targetSum = 3;
        TreeNode root = treeBuilder.buildTree(preorder1,inorder1);
        System.out.println("targetSum paths : "+app.pathSum(root,targetSum));
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList<List<Integer>>();
        possiblePath = new ArrayList<Integer>();
        preOrder(root,0,targetSum);
        return paths;
    }
    List<List<Integer>> paths;  List<Integer> possiblePath;
    private void preOrder(TreeNode root,int sum,int target){
        if (root==null) return;

        possiblePath.add(root.val);
        sum+=root.val;
        if (sum==target && root.left==null && root.right==null) paths.add(new ArrayList<>(possiblePath));

        preOrder(root.left,sum,target);
        preOrder(root.right, sum, target);

        possiblePath.remove(possiblePath.size()-1);//backtracking
    }
}