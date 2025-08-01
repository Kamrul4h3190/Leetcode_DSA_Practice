package leetcode_92;

public class App {
    public static void main(String[] args) {
        App app = new App();    ListNode listBuilder = new ListNode();
        ListNode list = listBuilder.buildList(new int[]{1,2,3,4,5}); int left = 2,right = 4;
//        ListNode list = listBuilder.buildList(new int[]{1,2,3,4,5,6,7,8}); int left = 4,right = 6;
        System.out.println("reversed : "+listBuilder.printList(app.reverseBetween(list,left,right)));
    }
    public ListNode reverseBetween(ListNode head, int left, int right){
        if(head.next == null || left==right) return head;

        ListNode newPreHead = new ListNode(-1,head);
        ListNode leftJoin = newPreHead;
        int i=1;
        for (; i <left ; i++) leftJoin = leftJoin.next;
        ListNode rightJoin = leftJoin.next;

        ListNode prev = leftJoin.next;
        ListNode curr = prev.next;
        ListNode next = prev.next;
        for (; i <right ; i++){
            if (i==left) prev.next = null;//break the left join
            next = curr.next;//before back linking preserve next

            curr.next = prev;//back linking
            prev = curr;
            curr = next;
        }

        leftJoin.next = prev;
        rightJoin.next = curr;
        return newPreHead.next;
    }
}
