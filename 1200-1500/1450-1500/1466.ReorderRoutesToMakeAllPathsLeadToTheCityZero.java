1466. Reorder Routes to Make All Paths Lead to the City Zero
Medium 3.7K 85

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). 
Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
It's guaranteed that each city can reach city 0 after reorder.

Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 2:
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 
Constraints:
2 <= n <= 5 * 104
connections.length == n - 1
connections[i].length == 2
0 <= ai, bi <= n - 1
ai != bi 
Accepted 143.4K Submissions 218.1K Acceptance Rate 65.7%

Answer:
//把这个改成我的风格了https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/solutions/661672/c-java-track-direction/
class Solution {
    public int minReorder(int n, int[][] connections) {
        if(connections == null || connections.length == 0 || connections[0].length == 0) return 0;
        int[] visited = new int[n];
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] c : connections){
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(-c[0]);
        }
        return helper(graph, visited, 0);
    }

    public int helper(List<List<Integer>> graph, int[] visited, int start){
        int change = 0;
        visited[start] = 1;
        for(int next : graph.get(start)){
            if(visited[Math.abs(next)] != 1) {
                change = change + helper(graph, visited, Math.abs(next)) + ((next > 0) ? 1 : 0);
            }
        }
        return change;
    }
}
