//this is a must remember question
200. Number of Islands
Medium

Given a 2d grid map of '1's (land) and '0's (water), 
count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3

Answer:
//DFS + BFS + Union Find, you must know all of the 3 methods.同时要复习1162的解法
//DFS:
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return result;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1') {
                    result++;
                    helper(grid, i, j);
                }
            }
        }
        
        return result;
    }
    
    public void helper(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        //be careful, here is '0'
        grid[i][j] = '0';
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
    }
}

//BFS:
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0) return result;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1') {
                    result++;
                    helper(grid, i, j);
                }
            }
        }
        
        return result;
    }
    
    public void helper(char[][] grid, int x, int y){
        grid[x][y] = '0';
        int row = grid.length;
        int col = grid[0].length;
        
        int elementId = x * col + y;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(elementId);
        
        while(!queue.isEmpty()){
            int id = queue.poll();
            int i = id / col;
            int j = id % col;
            if(i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * col + j);
                grid[i - 1][j] = '0';
            }
            if(i < row - 1 && grid[i + 1][j] == '1'){
                queue.offer((i + 1) * col + j);
                grid[i + 1][j] = '0';
            }
            if(j > 0 && grid[i][j - 1] == '1'){
                queue.offer(i * col + j - 1);
                grid[i][j - 1] = '0';
            }
            if(j < col - 1 && grid[i][j + 1] == '1'){
                queue.offer(i * col + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}


//Union Find:
//https://www.youtube.com/watch?v=VJnUwsE4fWA
//https://www.youtube.com/watch?v=0jNmHPfA_yE
class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        UnionFind uf = new UnionFind(grid);
        
        int row = grid.length;  
        int col = grid[0].length;  
        for (int i = 0; i < row; i++) {  
            for (int j = 0; j < col; j++) {  
                if(grid[i][j] == '1') {
                    for(int[] di : directions){
                        int x = i + di[0];
                        int y = j + di[1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {  
                            int id1 = i * col + j;
                            int id2 = x * col + y;
                            uf.union(id1, id2);  
                        }  
                    }
                }
            }
        }
        
        return uf.count;
    }
    
    public class UnionFind{
        int count;
        int[] parent;
        public UnionFind(char[][] grid){
            count = 0;
            parent = new int[grid.length * grid[0].length];
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == '1'){
                        int id = i * grid[0].length + j;
                        parent[id] = id;
                        count++;
                    }
                }
            }
        }        
        public int find(int id){
            if(id == parent[id]) {
                return id;
            }
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
