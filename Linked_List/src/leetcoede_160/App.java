package leetcoede_160;

public class App {
    public static void main(String[] args) {
        App app = new App();    ListNode listBuilder = new ListNode(-1);
        ListNode lista = listBuilder.buildList(new int[]{4,1});
        ListNode listb = listBuilder.buildList(new int[]{5,6,1});
        ListNode listc = listBuilder.buildList(new int[]{8,4,5});
//        ListNode lista = listBuilder.buildList(new int[]{1});
//        ListNode listb = listBuilder.buildList(new int[]{1});
//        ListNode listc = listBuilder.buildList(new int[]{1});
        listBuilder.intersectLists(lista,listb,listc);
        System.out.println(listBuilder.printList(lista));

        System.out.println("Intersection node : "+app.getIntersectionNode(lista,listb).val);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {//pointer switching approach
        ListNode nodeA=headA,nodeB = headB;
        while (nodeA!=nodeB){
            nodeA = (nodeA==null) ? headB : nodeA.next;
            nodeB = (nodeB==null) ? headA : nodeB.next;
        }
        return nodeA;
    }
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {//length difference approach
//        ListNode nodeA=headA,nodeB = headB; int lenA=0,lenB = 0;
//        while (nodeA!=null){lenA++;nodeA=nodeA.next;};
//        while (nodeB!=null){lenB++;nodeB=nodeB.next;};
//
//        ListNode largeList = (lenA>lenB) ? headA : headB;
//        ListNode smallList = (largeList==headA) ? headB : headA;//if A is large B is small,else A is small
//
//        int skips = Math.abs(lenA-lenB);
//
//        ListNode intersection = null;
//        for (int i = 0; i < skips; i++) largeList = largeList.next;//skipping
//        if (largeList==smallList) return largeList;//after skipping enough, maybe intersect, return any
//        while (largeList!=null && smallList!=null){
//            largeList = largeList.next; smallList=smallList.next;
//            if (largeList==smallList){
//                intersection=largeList;//intersected
//                break;
//            }
//        }
//
//        return intersection;
//    }
}
