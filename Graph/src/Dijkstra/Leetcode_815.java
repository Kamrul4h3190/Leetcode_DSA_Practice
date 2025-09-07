package Dijkstra;


import java.util.*;

public class Leetcode_815 {
    public static void main(String[] args) {
        Leetcode_815 app = new Leetcode_815();
//        int[][] routes = {{1,2,7},{3,6,7},{3,1,8}}; int source = 1,target = 6;
        int[][] routes = {{7,12},{4,5,15},{6},{15,19},{9,12,13}};int source = 15, target = 12;
        System.out.println("minimum buses : " + app.numBusesToDestination(routes,source,target));
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target) return 0;
        HashMap<Integer,List<Integer>> stopToRoutesMap = new HashMap<>();
        for (int route = 0; route < routes.length; route++) {
            for (int stop : routes[route]) {
                if (!stopToRoutesMap.containsKey(stop))
                    stopToRoutesMap.put(stop,new ArrayList<>());
                stopToRoutesMap.get(stop).add(route);
            }
        }
        Queue<Integer> queueRouts = new LinkedList<>();
        HashSet<Integer> visitedRouts = new HashSet<>();

        for (int route : stopToRoutesMap.getOrDefault(source,Collections.emptyList())) {//enqueue source starting all routes
            queueRouts.offer(route);
            visitedRouts.add(route);
        }
        int bus=0;
        while (!queueRouts.isEmpty()){
            int levelSize = queueRouts.size();
            bus++;
            for (int i = 0; i < levelSize; i++) {
                int currRoute = queueRouts.poll();

                for (int stop : routes[currRoute]) {
                    if (stop==target) return bus;

                    for (int nextRoute:stopToRoutesMap.getOrDefault(stop,Collections.emptyList())){//exception safety
                        if (visitedRouts.contains(nextRoute)) continue;
                        queueRouts.offer(nextRoute);
                        visitedRouts.add(nextRoute);
                    }
                }
            }
        }
        return -1;
    }
}