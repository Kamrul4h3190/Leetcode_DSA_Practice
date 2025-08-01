package leetcode_61;

public class App {
    public static void main(String[] args) {
        App app = new App();    ListNode listBuilder = new ListNode();
        ListNode list = listBuilder.buildList(new int[]{0,1,2}); int k = 4;
//        ListNode list = listBuilder.buildList(new int[]{1,2,3,4,5}); int k = 2;
        System.out.println("rotated : "+listBuilder.printList(app.rotateRight(list,k)));
    }
    public ListNode rotateRight(ListNode head, int k){
        if(head==null || head.next ==null || k==0) return head;
        ListNode newPreHead = new ListNode(-1,head);

        ListNode tail = head;   int nodes = 1;//find tail and number of nodes
        while (tail.next!=null) {tail=tail.next; nodes++;}

        k = k%nodes;//reducing K to fit in list size

        ListNode cut = head;//find where to cut the list
        for (int i = 1; i < nodes-k ; i++) cut = cut.next;

        tail.next = head;//Join
        newPreHead.next = cut.next;
        cut.next = null;

        return newPreHead.next;
    }
}
