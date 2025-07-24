package BST.leetcode_2476;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        App app = new App();
        int[] preorder = {6,2,1,4,13,9,15,14};
        TreeNode root = TreeNode.bstFromPreorder(preorder);//build input tree
        ArrayList<Integer> queries = new ArrayList<>(Arrays.asList(2,5,16));
        System.out.println("BST bounded search : "+ app.closestNodes(root,queries));
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> boundaries = new ArrayList<>();
        ArrayList<Integer> inorder = inOrder(root,new ArrayList<>());
        for (int query:queries)
            boundaries.add(boundedBinarySearch(inorder,query)) ;

        return boundaries;
    }
    private List<Integer> boundedBinarySearch(ArrayList<Integer> inorder,int pivotVal){
        int ub=Integer.MAX_VALUE,lb=Integer.MIN_VALUE;
        int left = 0,right=inorder.size()-1;
        while (left<=right){
            int mid = (left+right)/2;
            int currValue = inorder.get(mid);
            if (currValue ==pivotVal) return new ArrayList<>(Arrays.asList(currValue,currValue));

            if (pivotVal<currValue){
                ub = Math.min(ub,currValue);
                right = mid-1;
            }else{
                lb = Math.max(lb,currValue);
                left = mid + 1;
            }
        }
        if (lb==Integer.MIN_VALUE) lb = -1;if (ub==Integer.MAX_VALUE) ub = -1;

        return new ArrayList<>(Arrays.asList(lb,ub));
    }
//    private List<Integer> boundedBinarySearch(TreeNode root,int pivotVal){//TLE. traversing over tree each time
//        int ub=Integer.MAX_VALUE,lb=Integer.MIN_VALUE;
//        while (root!=null){
//            if (pivotVal<root.val){
//                ub = Math.min(ub,root.val);
//                root = root.left;
//            }else if (pivotVal>root.val) {
//                lb = Math.max(lb, root.val);
//                root = root.right;
//            }else {//equal found
//                return new ArrayList<>(Arrays.asList(root.val,root.val));
//            }
//        }
//        if (lb==Integer.MIN_VALUE) lb = -1;if (ub==Integer.MAX_VALUE) ub = -1;
//
//        return new ArrayList<>(Arrays.asList(lb,ub));
//    }
   private ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> sorted){//traversal function
        if (root==null) return null;

        inOrder(root.left,sorted);
        sorted.add(root.val);
        inOrder(root.right,sorted);

        return sorted;
    }
}