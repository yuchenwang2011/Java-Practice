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
//from this solution https://leetcode.com/problems/minimum-height-trees/solutions/76055/share-some-thoughts/
//那个附带的310的图片，一图顶千言。从comment里找的
//time O(n) space O(n)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n <= 0) return result;
        if(edges.length != n - 1) return result;
        if(n == 1) {
            result.add(0);
            return result;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int key : map.keySet()){
            Set<Integer> tmp = map.get(key);
            if(tmp.size() == 1) leaves.add(key);
        }

        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){
                int next = map.get(leaf).iterator().next();
                map.get(next).remove(leaf);
                if(map.get(next).size() == 1) newLeaves.add(next);
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
