310. Minimum Height Trees
Medium

For an undirected graph with tree characteristics, 
we can choose any node as the root. The result graph is then a rooted tree. 
Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). 
Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. 
You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :
Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]

Example 2 :
Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

Output: [3, 4]
Note:

According to the definition of tree on Wikipedia: 
“a tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.”
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
Accepted 75,045 Submissions 242,274

Answer:
//time O(n) space O(n)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n == 1) {
            result.add(0);
            return result;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            graph.putIfAbsent(a, new HashSet<>());
            graph.putIfAbsent(b, new HashSet<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int key : graph.keySet()){
            if(graph.get(key).size() == 1) result.add(key);
        }
        
        while(n > 2){
            n -= result.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int i : result){
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i); //j单方面和i恩断义绝
                if(graph.get(j).size() == 1) newLeaves.add(j);
            } 
            result = newLeaves;
        }
        return result;
    }
}
