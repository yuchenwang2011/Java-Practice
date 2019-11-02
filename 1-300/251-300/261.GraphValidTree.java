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
        if(edges == null || edges.length == 0){
            return n == 1;   
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        boolean result = helper(graph, visited, edges[0][0], -1);
        if(result == false) return false;
        return visited.size() == n;
    }
    
    public boolean helper(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int current, int last){
        if(!graph.containsKey(current)) return false;
        Set<Integer> set = graph.get(current);
        
        visited.add(current);
        for(int next : set){
            if(next == last) continue;
            if(visited.contains(next)) return false;
            boolean result = helper(graph, visited, next, current);
            if(result == false) return false;
        }
        return true;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length == 0) {
            return n == 1;
        } 
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            int id1 = uf.find(edge[0]);
            int id2 = uf.find(edge[1]);
            if(id1 == id2) return false;
            uf.union(id1, id2);
        }
        return uf.count == 1;
    }
    
    public class UnionFind{
        int count = 0;
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                count++;
            }
        }
        
        public int find(int id){
            if(id == parent[id]) return id;
            parent[id] = find(parent[id]);
            return parent[id];
        }
        
        public void union(int id1, int id2){
            int root1 = find(id1);
            int root2 = find(id2);
            if(root1 != root2) {
                parent[root1] = root2;
                count--;
            }
        }
    }
}
