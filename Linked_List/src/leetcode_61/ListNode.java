package leetcode_61;

import java.util.ArrayList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
}
