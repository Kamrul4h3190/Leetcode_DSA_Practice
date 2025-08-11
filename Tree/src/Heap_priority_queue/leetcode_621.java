package Heap_priority_queue;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_621 {
    public static void main(String[] args) {
        leetcode_621 app = new leetcode_621();
        char[] tasks = new char[]{'A','A','A','B','B','B'}; int n = 2;
        System.out.println("minimum intervals : "+app.leastInterval(tasks,n));
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Task> freqMap = new HashMap<>();
        for (char c : tasks) {
            freqMap.putIfAbsent(c,new Task(c,0));
            freqMap.get(c).freq++;
        }

        PriorityQueue<Task> queue = new PriorityQueue<>((a,b)->b.freq-a.freq);
        queue.addAll(freqMap.values());

        int intervals=0;
        while(!queue.isEmpty()){//as long as there are tasks
            int clock = n+1;//allocate clock timing for current cycle
            List<Task> CPU = new ArrayList<>();//allocate cpu for current clock cycle
            while (clock>0 && !queue.isEmpty()){//as long as clock exists, and tasks are in queue
                Task task = queue.poll();
                task.freq--;
                CPU.add(task);

                clock--;
                intervals++;
            }

            for (Task task : CPU) if (task.freq>0) queue.add(task);//enqueue remaining tasks,for executing in next clock

            if (queue.isEmpty()) break;//if clock leftover,but queue became empty, no need to add remaining clocks.this is tha last task
            intervals += clock;

        }
        return intervals;
    }
    class Task{
        char label; int freq;
        public Task(char label, int freq) {this.label = label;this.freq = freq;}
    }
}