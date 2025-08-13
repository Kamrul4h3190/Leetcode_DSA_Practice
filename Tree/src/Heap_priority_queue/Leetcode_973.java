package Heap_priority_queue;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode_973 {
    public static void main(String[] args) {
        Leetcode_973 app = new Leetcode_973();
        int[][] points = {{3,3},{5,-1},{-2,4}}; int k=2;
        System.out.println("k closest points : "+ Arrays.deepToString(app.kClosest(points, k)));
    }
    public int[][] kClosest(int[][] points, int k) {
        Point[] pointArray = new Point[points.length]; int i = 0;
        for (int[] point : points) {
            Point pointObject = new Point(point[0],point[1]);
            pointObject.distance = (pointObject.x)*(pointObject.x) + (pointObject.y)*(pointObject.y) ;

            pointArray[i++] = pointObject;
        }

        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a,b)->b.distance-a.distance);
        for (Point point : pointArray) {
            maxHeap.offer(point);
            if (maxHeap.size()>k) maxHeap.poll();
        }

        int[][] closestPoints = new int[k][]; i=0;
        while (!maxHeap.isEmpty()){
            Point point = maxHeap.poll();
            closestPoints[i++] = new int[]{point.x, point.y};
        }
        return closestPoints;
    }

    class Point {
        int x,y,distance;
        public Point(int x, int y) {this.x = x;this.y = y;}
    }
}