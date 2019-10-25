323. Number of Connected Components in an Undirected Graph
Medium

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to find the number of connected components in an undirected graph.

Example 1:
Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2

Example 2:
Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, 
[0, 1] is the same as [1, 0] and thus will not appear together in edges.

Accepted 71,682 Submissions 134,674
Answer:
//我自己写的DFS
class Solution {
    int result = 0;
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int result = 0;
        Set<Integer> visited = new HashSet<>();

        for(int key : graph.keySet()){
            if(visited.add(key)) result++;
            helper(graph, key, visited);
        }
        //如果给的是4，[12][23][31]，你还得考虑4
        for(int i = 0; i < n; i++){
            if(visited.add(i)) result++;
        }
        return result;
    }
    
    public void helper(Map<Integer, Set<Integer>> graph, int key, Set<Integer> visited){
        if(!graph.containsKey(key)) return;
        Set<Integer> set = graph.get(key);
        for(int node : set){
            if(!visited.add(node)) continue;
            helper(graph, node, visited);
        }
    }
}
