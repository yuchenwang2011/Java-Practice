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
    int result;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        result = Integer.MAX_VALUE;
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight : flights){
            int a = flight[0];
            int b = flight[1];
            int c = flight[2];
            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, c);
        }
        helper(graph, src, dst, K + 1, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public void helper(Map<Integer, Map<Integer, Integer>> graph, int src, int dst, int K, int cost){
        if(K < 0) return;
        if(src == dst) {
            if(cost < result) {
                result = cost;
                return;
            }
        }
        if(!graph.containsKey(src)) return;
        Map<Integer, Integer> nexts = graph.get(src);
        for(int next : nexts.keySet()){
            int newCost = cost + nexts.get(next);
            if(newCost > result) continue;
            helper(graph, next, dst, K - 1, newCost);
        }
    }
}

//BFS
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int result = Integer.MAX_VALUE;
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight : flights){
            int a = flight[0];
            int b = flight[1];
            int c = flight[2];
            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, c);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        K = K + 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(K < 0) break;
            for(int i = 0; i < size; i++){
                int[] flight = queue.poll();
                if(flight[0] == dst) {
                    if(flight[1] < result) {
                        result = flight[1];
                        continue;
                    }
                }
                if(!graph.containsKey(flight[0])) continue;
                Map<Integer, Integer> nexts = graph.get(flight[0]);
                for(int next : nexts.keySet()){
                    int newCost = flight[1] + nexts.get(next);
                    if(newCost > result) continue;
                    queue.offer(new int[]{next, newCost});
                }
            }
            K--;
        }
        return result == Integer.MAX_VALUE? -1 : result;
    }
}
