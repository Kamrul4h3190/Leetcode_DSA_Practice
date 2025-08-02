package leetcode_23;

public class App {
    public static void main(String[] args) {
        App app = new App();    ListNode listBuilder = new ListNode();
        ListNode[] lists = new ListNode[]{listBuilder.buildList(new int[]{1,4,5}),
                listBuilder.buildList(new int[]{1,3,4}),listBuilder.buildList(new int[]{2,6})};
        System.out.println("rotated : "+listBuilder.printList(app.mergeKLists(lists)));
    }
    public ListNode mergeKLists(ListNode[] lists) {//reduce the problem to merge 2 sorted lists.
        if (lists.length == 0) return null;
        return partition(0, lists.length-1 ,lists);
    }
    private ListNode partition(int start, int end, ListNode[] lists){
        if (start==end) return lists[start];

        int mid = (start+end)/2;
        ListNode leftList = partition(start,mid,lists);
        ListNode rightList = partition(mid+1,end,lists);

        return merge(leftList,rightList);
    }

    private ListNode merge(ListNode leftList, ListNode rightList) {
        if(leftList==null) return rightList;
        if(rightList==null) return leftList;

        if(leftList.val< rightList.val){
            leftList.next = merge(leftList.next, rightList);
            return leftList;
        }else {
            rightList.next = merge(leftList, rightList.next);
            return rightList;
        }
    }
}
