package Binary_Tree.leetcode_437;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        App app = new App();    TreeNode treeBuilder = new TreeNode();
//        int[] preorder1 = {1,2,2};int[] inorder1 = {2,1,2}; int targetSum = 0;
        TreeNode root = new TreeNode(1000000000);TreeNode curr = root;
        curr.left = new TreeNode(1000000000);curr=curr.left;
        curr.left = new TreeNode(294967296);curr=curr.left;
        curr.left = new TreeNode(1000000000);curr=curr.left;
        curr.left = new TreeNode(1000000000);curr=curr.left;
        curr.left = new TreeNode(1000000000);curr=curr.left;
//        TreeNode root = treeBuilder.buildTree(preorder1,inorder1);
        System.out.println("targetSum paths : "+app.pathSum(root,0));
//        System.out.println("targetSum paths : "+app.pathSum(root,targetSum));
    }
    int paths = 0;
    HashMap<Long, Integer> sumFreqMap = new HashMap();
    public int pathSum(TreeNode root, int sum) {
        sumFreqMap.put(0L,1);
        countTargetSumPaths(root, 0, sum);
        return paths;
    }
    public void countTargetSumPaths(TreeNode root, long currSum, int target) {
        if (root == null) return;

        currSum += root.val;//addition may cause overflow.large numbers.long

        if (sumFreqMap.containsKey(currSum - target)) paths += sumFreqMap.get(currSum - target);
        sumFreqMap.put(currSum, sumFreqMap.getOrDefault(currSum,0)+1);

        countTargetSumPaths(root.left, currSum, target);
        countTargetSumPaths(root.right, currSum, target);
        sumFreqMap.put(currSum, sumFreqMap.get(currSum) - 1);
    }
}