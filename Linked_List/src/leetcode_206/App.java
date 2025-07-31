package leetcode_206;

public class App {
    public static void main(String[] args) {
        App app = new App();    ListNode listBuilder = new ListNode(-1);
        ListNode list = listBuilder.buildList(new int[]{1,2,3,4});

        System.out.println("reversed : "+listBuilder.printList(app.reverseList(list)));
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;   ListNode curr = head,next = head;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
