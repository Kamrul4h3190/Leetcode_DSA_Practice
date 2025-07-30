package BST.leetcode_1373;
//failed.Not commited
public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {10,20,5,25,22,27,50,80,55,70,10,5,15};
//        int[] preorder = {4,2,1,3,6};
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree

        System.out.println("max BST sum : "+ app.maxSumBST(root));
    }
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }
    private Node postOrder(TreeNode root){
//        if (root==null) return new Node(Integer.MIN_VALUE,0,Integer.MAX_VALUE);
        if (root==null) return new Node(Integer.MAX_VALUE,0,Integer.MIN_VALUE);
        Node left = postOrder(root.left);
        Node right = postOrder(root.right);

        if (root.val> left.rightVal && root.val < right.leftVal) {
            int currSum = root.val + left.nodeSum + right.nodeSum;
            maxSum = Math.max(maxSum,currSum);
            int leftVal = Math.min(root.val, left.leftVal);
            int rightVal = Math.max(root.val, right.rightVal);
            return new Node(leftVal,rightVal,maxSum);
        }
        int maxSum = Math.max(left.nodeSum,right.nodeSum);
        return new Node(Integer.MIN_VALUE,maxSum,Integer.MAX_VALUE);

    }
    class Node{
        int leftVal;int nodeSum;int rightVal;
        public Node(int leftVal, int nodeSum, int rightVal) {
            this.leftVal = leftVal;
            this.nodeSum = nodeSum;
            this.rightVal = rightVal;
        }
    }

}
//class Node{
//    int leftMax;
//    int nodeSum;
//    int rightMin;
//
//    public Node(int leftMax, int nodeSum, int rightMin) {
//        this.leftMax = leftMax;
//        this.nodeSum = nodeSum;
//        this.rightMin = rightMin;
//    }
//}