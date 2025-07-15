package BST.leetcode_109;

class Leetcode_109 {
    public static void main(String[] args) {
        Leetcode_109 app = new Leetcode_109();
        int[] nums = {-10,-3,0,5,9};
        ListNode head = ListNode.buildList(nums);

        TreeNode root = app.sortedListToBST(head);
        TreeNode.inOrder(root);
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        ListNode mid = findMiddle(head);
        TreeNode root = new TreeNode(mid.val);
        if (mid==head) return root;

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    private ListNode findMiddle(ListNode head){
        ListNode prev=head,slow=head,fast=head;
        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast  = fast.next.next;
        }
        if (prev!=null) prev.next = null;

        return slow;
    }
}
