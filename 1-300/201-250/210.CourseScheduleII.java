210. Course Schedule II
Medium

There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, 
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. 
If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
             
Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
             
Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Answer:
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses < 0) return new int[0];
        //line below not needed, for this case, 1 [], expected [0], not []
        //if(prerequisites == null || prerequisites.length == 0) return new int[0];
        
        int[] indegree = new int[numCourses];
        for(int[] course : prerequisites){
            indegree[course[0]]++;
        }
        
        int[] result = new int[numCourses];
        int count = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) {
                queue.offer(i);
                result[count++] = i;
            }
        }
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int[] course : prerequisites){
                if(course[1] == num) {
                    indegree[course[0]]--;
                    if(indegree[course[0]] == 0) {
                        queue.offer(course[0]);
                        result[count++] = course[0];
                    }
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }
}



class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //prepare
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            int prev = pair[1];
            int next = pair[0];
            graph.get(prev).add(next);
        }

        Map<Integer, Integer> visited = new HashMap<>();
        //initail visited
        for(int i = 0; i < numCourses; i++){
            visited.put(i, 0);//0 -> unvisited, 1 -> visiting, 2 -> visited
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            if(!topoSort(res, graph, visited, i)) return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = res.get(numCourses - i - 1);
        }
        return result;
    }

    //the return value of this function only contains the ifCycle info and does not interfere dfs process. if there is Cycle, then return false
    private boolean topoSort(List<Integer> res, List<List<Integer>> graph, Map<Integer, Integer> visited, int i){
        int visit = visited.get(i);
        if(visit == 2){//when visit = 2, which means the subtree whose root is i has been dfs traversed and all the nodes in subtree has been put in the result(if we request), so we do not need to traverse it again
            return true;
        }if(visit == 1){
            return false;
        }

        visited.put(i, 1);
        for(int j : graph.get(i)){
            if(!topoSort(res, graph, visited, j)) return false;
        }
        visited.put(i, 2);
        res.add(i);//the only difference with traversing a graph

        return true;
    }
}
