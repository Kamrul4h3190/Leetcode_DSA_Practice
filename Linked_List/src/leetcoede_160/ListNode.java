package leetcoede_160;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;
    next = null;
    }
    public ListNode buildList(int[] nums){
        ListNode preHead = new ListNode(-1);ListNode curr = preHead;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return preHead.next;
    }
    public ArrayList<Integer> printList(ListNode head){
        ArrayList<Integer> nodes = new ArrayList<>();
        while (head!=null){
            nodes.add(head.val);
            head = head.next;
        }
        return nodes;
    }
    public void intersectLists(ListNode headA, ListNode headB,ListNode headC){
        ListNode tailA=headA;ListNode tailB = headB;
        while (tailA.next!=null) tailA = tailA.next;
        while (tailB.next!=null) tailB = tailB.next;
        tailA.next = headC;
        tailB.next = headC;
    }
}
