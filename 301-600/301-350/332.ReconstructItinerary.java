332. Reconstruct Itinerary
Medium

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], 
reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. 
Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary 
that has the smallest lexical order when read as a single string. 
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
             
Answer:
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new LinkedList<>();
        if(tickets == null || tickets.size() == 0) return result;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        helper(graph, result, "JFK");
        return result;
    }
    
    public void helper(Map<String, PriorityQueue<String>> graph, List<String> result, String stop){
        PriorityQueue<String> pq = graph.get(stop);
        while(pq != null && !pq.isEmpty()){
            helper(graph, result, pq.poll());
        }
        result.add(0, stop);
    }
}
