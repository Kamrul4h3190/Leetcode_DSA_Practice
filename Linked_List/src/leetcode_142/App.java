package leetcode_142;

public class App {
    public static void main(String[] args) {
        App app = new App();    ListNode listBuilder = new ListNode();
        ListNode head = listBuilder.buildList(new int[]{3,2,0,-4});
        ListNode tail = listBuilder.getTail(head);
        listBuilder.addCycle( head,tail,1);
        System.out.println("cycle starts at : "+app.detectCycle(head).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next==null) return null;

        ListNode slow=head,fast = head;//detect cycle
        while (fast!=null && fast.next!=null){
            slow = slow.next;   fast = fast.next.next;
            if (slow==fast) break;//cycle found
        }
        if (fast==null || fast.next == null) return null;//loop finished founding no cycle

        ListNode  p = head;//find cycle starting node
        while (p!=slow) {p=p.next;  slow=slow.next;}
        return p;//or slow
    }
}
