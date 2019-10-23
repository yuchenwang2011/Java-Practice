787. Cheapest Flights Within K Stops
Medium

There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, 
your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.


Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:
The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.

Note:
The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.

Answer:
//this question DFS + BFS, where BFS is much faster than DFS.
//DFS solution
class Solution {
    int result = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(n <= 0 || flights == null || flights.length <= 0 || K < 0) return -1;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] flight : flights){
            if(!map.containsKey(flight[0])) map.put(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
    
        helper(map, src, dst, K, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public void helper(Map<Integer, Map<Integer, Integer>> graph, int src, int dst, int k, int cost){
        if(src == dst) {
            if(cost <= result) result = cost;
            return;
        }
        if(k < 0 || src == dst) return;
        
        Map<Integer, Integer> map = graph.get(src);
        if(map == null || map.size() == 0) return;
        for(int stop : map.keySet()){
            int newCost = cost + map.get(stop);
            if(newCost > result) continue; 
            helper(graph, stop, dst, k - 1, newCost);
        }
    }
}

//BFS
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] flight : flights){
            if(!map.containsKey(flight[0])) map.put(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        
        int result = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        
        int step = 0;
        while(!queue.isEmpty()){
            if(step > K + 1) break;
            System.out.println(step);
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] stop = queue.poll();
                if(stop[0] == dst) {
                    result = Math.min(result, stop[1]);
                    continue;
                }
                
                if(!map.containsKey(stop[0])) continue;
                Map<Integer, Integer> nodes = map.get(stop[0]);
                for(int next : nodes.keySet()){
                    int newCost = nodes.get(next) + stop[1];
                    if(newCost > result) continue;
                    queue.offer(new int[]{next, newCost});
                }
            }
            step++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
