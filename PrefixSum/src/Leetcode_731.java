import java.util.Map;
import java.util.TreeMap;

public class Leetcode_731 {
    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(50,60));
    }
    static class MyCalendarTwo {
        private TreeMap<Integer, Integer> bookings;//<index,taskPeriod>
        private int maxAllowed;

        public MyCalendarTwo() {
            bookings = new TreeMap<>();
            maxAllowed = 2;
        }

        public boolean book(int start, int end) {
            bookings.put(start, bookings.getOrDefault(start, 0) + 1);//effect
            bookings.put(end, bookings.getOrDefault(end, 0) - 1);

            int overlapCount = 0;

            for (Map.Entry<Integer, Integer> entry : bookings.entrySet()) {
                overlapCount += entry.getValue();
                if (overlapCount > maxAllowed) {//reduce effect, and return false
                    bookings.put(start, bookings.get(start) - 1);
                    bookings.put(end, bookings.get(end) + 1);
                    return false;
                }
            }
            return true;
        }
    }
}