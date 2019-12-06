1192. Critical Connections in a Network
Hard

There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections 
forming a network where connections[i] = [a, b] represents a connection between servers a and b. 
Any server can reach any other server directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some server unable to reach some other server.
Return all critical connections in the network in any order.

Example 1:
Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
 
Constraints:
a. 1 <= n <= 10^5
b. n-1 <= connections.length <= 10^5
c. connections[i][0] != connections[i][1]
d. There are no repeated connections.
Accepted 17,703 Submissions 36,374

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<List<Integer>> result = new ArrayList<>();
		if(n <= 0 || connections == null) return result;
		List<Integer>[] graph = new ArrayList[n];
		for(int i = 0; i < n; i++){
			graph[i] = new ArrayList<>();
		}

		for(List<Integer> list : connections){
			if(list == null || list.size() < 2) return result;
			int a = list.get(0);
			int b = list.get(1);
			graph[a].add(b);
			graph[b].add(a);
		}

		int[] visited = new int[n];
		int[] lowerLevel = new int[n]; //the lowest level inside the graph, which the node can reach back to.
		Arrays.fill(visited, -1);
		for(int i = 0; i < n; i++){
			if(visited[i] == -1) {
				helper(n, result, graph, visited, lowerLevel, i, i);
			}
		}
		return result;
	}

	private int time = 0;
	public void helper(int n, List<List<Integer>> result, List<Integer>[] graph, int[] visited, int[] lowerLevel, int current, int prev){
		visited[current] = lowerLevel[current] = ++time;
		List<Integer> set = graph[current];
		for(int next : set){
			if(next == prev) continue;

			if(visited[next] == -1) {
				helper(n, result, graph, visited, lowerLevel, next, current);
				lowerLevel[current] = Math.min(lowerLevel[current], lowerLevel[next]);
				//if there is no path for next to reach back to current or previous vertices of current
				if(lowerLevel[next] > visited[current]) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(current);
                    tmp.add(next);
					Collections.sort(tmp);
					result.add(tmp);
				}
			} else {
				//if next already discovered, update low[current]
				//cannot use low[v] because current is not subtree of next
				lowerLevel[current] = Math.min(lowerLevel[current], visited[next]);
			}
		}
	}

}
