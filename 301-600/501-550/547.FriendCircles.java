547. Friend Circles
Medium


There are N students in a class. Some of them are friends, while some are not. 
Their friendship is transitive in nature. For example, if A is a direct friend of B, 
and B is a direct friend of C, then A is an indirect friend of C. 
And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. 
If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
And you have to output the total number of friend circles among all the students.

Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.

Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.

Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
Accepted 113,584 Submissions 203,960

Answer:
//必须会两种方法
class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;
        
        UnionFind uf = new UnionFind(M);
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < i; j++){
                if(M[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        return uf.count;
    }
    
    public class UnionFind{
        int count;
        int[] parent;
        
        public UnionFind(int[][] M){
            count = 0;
            parent = new int[M.length];
            for(int i = 0; i < M.length; i++){
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

class Solution {
    public int findCircleNum(int[][] M) {
        int result = 0;
        if(M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length) return result;
        int[] visited = new int[M.length];
        for(int i = 0; i < M.length; i++){
            if(visited[i] == 0) {
                helper(M, visited, i);
                result++;
            }
        }
        return result;
    }
    
    public void helper(int[][] M, int[] visited, int i){
        for(int j = 0; j < M.length; j++){
            if(M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                helper(M, visited, j);
            }
        }
    }
}
