261. Graph Valid Tree
Medium

Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true

Example 2:
Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.

Hint:
1. Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
2. According to the definition of tree on Wikipedia: 
“a tree is an undirected graph in which any two vertices are connected by exactly one path. 
In other words, any connected graph without simple cycles is a tree.”

Answer:
//这题必须会，是个图的题，第一个dfs，第二个union find
class Solution {
    public boolean validTree(int n, int[][] edges) {
        //第一行不用测试null和0啥的
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        boolean result = helper(graph, visited, 0, - 1);
        if(result == false) return false;
        return visited.size() == n ? true: false;
    }
    
    public boolean helper(List<List<Integer>> graph, Set<Integer> visited, int current, int parent){
        List<Integer> nodes = graph.get(current);
        for(int node : nodes){
            if(node == parent) continue;
            if(visited.contains(node)) return false;
            visited.add(node);
            boolean result = helper(graph, visited, node, current);
            if(result == false) return false;
        }
        return true;
    }
}


class Solution {
    //https://www.geeksforgeeks.org/union-find
    public boolean validTree(int n, int[][] edges) {
        if(n == 1 && edges.length == 0) return true;
        if(n < 1 || edges == null || edges.length != n - 1) return false;
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        for(int[] pair : edges){
            int x = find(roots, pair[0]);
            int y = find(roots, pair[1]);
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            roots[x] = y;
        }
        return true;
    }
    
    public int find(int[] roots, int i){
        while(roots[i] != -1){
            i = roots[i];
        }
        return i;
    }
}
