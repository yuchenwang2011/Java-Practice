841. Keys and Rooms
Medium 5.7K 250

There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. 
Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, 
and you can take all of them with you to unlock the other rooms.
Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.

Example 1:
Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation: 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

Example 2:
Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 
Constraints:
n == rooms.length
2 <= n <= 1000
0 <= rooms[i].length <= 1000
1 <= sum(rooms[i].length) <= 3000
0 <= rooms[i][j] < n
All the values of rooms[i] are unique.
Accepted 354.4K Submissions 491.6K Acceptance Rate 72.1%

Answer:
//my own answer
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < rooms.size(); i++){
            graph.put(i, rooms.get(i));
        }
        Set<Integer> visited = new HashSet<>();
        helper(graph, 0, visited);
        return visited.size() == graph.keySet().size();
    }

    public void helper(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited){
        if(!visited.add(start)) return;
        visited.add(start);
        List<Integer> nodes = graph.get(start);
        for(int i = 0; i < nodes.size(); i++){
            helper(graph, nodes.get(i), visited);
        }
    }
}

//简化了一下上面的答案就是
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return true;
        Set<Integer> visited = new HashSet<>();
        helper(rooms, 0, visited);
        return visited.size() == rooms.size();
    }

    public void helper(List<List<Integer>> rooms, int start, Set<Integer> visited){
        if(!visited.add(start)) return;
        visited.add(start);
        List<Integer> nodes = rooms.get(start);
        for(int i = 0; i < nodes.size(); i++){
            helper(rooms, nodes.get(i), visited);
        }
    }
}

//第二种BFS写法
//参考了https://leetcode.com/problems/keys-and-rooms/solutions/2080113/java-beginners-solution
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.size() == 0) return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[rooms.size()];

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(visited[current]) continue;
            visited[current] = true;
            List<Integer> next = rooms.get(current);
            for(int i = 0; i < next.size(); i++){
                queue.offer(next.get(i));
            }
        }

        for(boolean b : visited) {
            if(!b) return false;
        }
        return true;
    }
}
