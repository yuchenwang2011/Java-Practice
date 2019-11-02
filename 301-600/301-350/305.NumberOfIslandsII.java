305. Number of Islands II
Hard

A 2d grid map of m rows and n columns is initially filled with water. 
We may perform an addLand operation which turns the water at position (row, col) into a land. 
Given a list of positions to operate, count the number of islands after each addLand operation. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example:
Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:

Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
0 0 0
0 0 0
0 0 0

Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
1 0 0
0 0 0   Number of islands = 1
0 0 0

Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
1 1 0
0 0 0   Number of islands = 1
0 0 0

Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
1 1 0
0 0 1   Number of islands = 2
0 0 0

Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
1 1 0
0 0 1   Number of islands = 3
0 1 0

Follow up:
Can you do it in time complexity O(k log mn), where k is the length of the positions?

Accepted 63,235 Submissions 154,453

Answer:
//my own answer, faster than 92%
class Solution {
    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0 || positions == null || positions.length == 0) return result;
        
        UnionFind uf = new UnionFind(m, n);
        for(int[] position : positions){
            uf.add(position[0], position[1]);
            result.add(uf.count);
        }
        return result;
    }
    
    public class UnionFind{
        int count;
        int[] parent;
        int row;
        int col;
        public UnionFind(int m, int n){
            count = 0;
            parent = new int[m * n];
            Arrays.fill(parent, -1);
            row = m;
            col = n;
        }
        
        public int find(int id){
            if(id == parent[id]) return id;
            parent[id] = find(parent[id]);
            return parent[id];
        }
        
        public void add(int a, int b){            
            int id = a * col + b;
            if(parent[id] != -1) return;
            parent[id] = id;
            count++;
            
            for(int[] direction : directions) {
                int x = a + direction[0];
                int y = b + direction[1];
                if(x >= 0 && y >= 0 && x < row && y < col) {
                    int id2 = x * col + y;
                    if(parent[id2] != -1) union(id, id2);
                }
            }
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
