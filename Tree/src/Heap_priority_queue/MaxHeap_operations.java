package Heap_priority_queue;


import java.util.ArrayList;
import java.util.List;

public class MaxHeap_operations {
    public static void main(String[] args) {
        MaxHeap_operations app = new MaxHeap_operations();

//        Integer[] heap = {13,11,7,10,9,5};//build initial heap, level order
        Integer[] heap = {14,11,13,10,9,5,8};//build initial heap, level order
        app.maxHeap.addAll(List.of(heap));
        System.out.println("heap : "+app.maxHeap);
        System.out.println("extracted : "+app.extractMax());
        System.out.println("heap : "+app.maxHeap);
    }
    List<Integer> maxHeap = new ArrayList<>();
    public void insert(int value){
        maxHeap.add(value);
        int childIndex = maxHeap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while (childIndex>0 && maxHeap.get(parentIndex) < maxHeap.get(childIndex)){//while parent is less than child shuffle upward
            swap(childIndex,parentIndex,maxHeap);//shuffle up

            childIndex = parentIndex;//update child
            parentIndex = (childIndex-1)/2;//calculate parent for updated child
        }
    }
    public int extractMax(){
        int max = maxHeap.get(0); int n = maxHeap.size();//get max
        int root = 0;
        maxHeap.set(0,maxHeap.remove(n-1));//replace max with last val
        while (true){//heapify-down the root till there is a bigger child
            int left = 2*root+1, right = 2*root+2;
            int bigChild = root;//get bigger child, if any is there
            if (left<maxHeap.size() && maxHeap.get(left)>maxHeap.get(bigChild)) bigChild = left;
            if (right<maxHeap.size() && maxHeap.get(right)>maxHeap.get(bigChild)) bigChild = right;

            if (bigChild==root) break;//big Child not changed, heapify done.
            swap(bigChild,root,maxHeap);//heapify-down

            root = bigChild;//update root
        }
        return max;
    }
    public int peek(){
        return maxHeap.get(0);
    }
    private void swap(int ci,int pi,List<Integer> maxHeap){
        int temp = maxHeap.get(pi);
        maxHeap.set(pi,maxHeap.get(ci));
        maxHeap.set(ci,temp);
    }
}