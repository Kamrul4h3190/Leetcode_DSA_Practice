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
        if (root==null) return new Node(Integer.MAX_VALUE,0,Integer.MIN_VALUE);//back such that leaf validates as BST
        Node leftNode = postOrder(root.left);
        Node rightNode = postOrder(root.right);

        if (root.val> leftNode.nodeMax && root.val < rightNode.nodeMin) {
            int currSum = root.val +  leftNode.nodeSum + rightNode.nodeSum;
            maxSum = Math.max(maxSum,currSum);
            int nodeMin = Math.min(root.val, leftNode.nodeMin);//from right,convey to upward left
            int nodeMax = Math.max(root.val, rightNode.nodeMax);//from left,convey to upward right
            return new Node(nodeMin,currSum,nodeMax);
        }
        return new Node(Integer.MIN_VALUE,0,Integer.MAX_VALUE);//invalid BST
    }
    class Node{
        int nodeMin;int nodeSum;int nodeMax;
        public Node(int minVal, int nodeSum, int maxVal) {
            this.nodeMin = minVal;
            this.nodeSum = nodeSum;
            this.nodeMax = maxVal;
        }
    }
}