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
//DFS + BFS + Union Find, you must know all of the 3 methods
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
    int[][] distance = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {  
        if (grid == null || grid.length == 0 || grid[0].length == 0)  {
            return 0;  
        }
        UnionFind uf = new UnionFind(grid);  
        int rows = grid.length;  
        int cols = grid[0].length;  
        for (int i = 0; i < rows; i++) {  
            for (int j = 0; j < cols; j++) {  
                if (grid[i][j] == '1') {  
                    for (int[] d : distance) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {  
                            int id1 = i*cols+j;
                            int id2 = x*cols+y;
                            uf.union(id1, id2);  
                        }  
                    }  
                }  
            }  
        }  
        return uf.count;  
    }
    
    class UnionFind {
        int[] father;  
        int m, n;
        int count = 0;
        UnionFind(char[][] grid) {  
            m = grid.length;  
            n = grid[0].length;  
            father = new int[m*n];  
            for (int i = 0; i < m; i++) {  
                for (int j = 0; j < n; j++) {  
                    if (grid[i][j] == '1') {
                        int id = i * n + j;
                        father[id] = id;
                        count++;
                    }
                }  
            }  
        }
        public void union(int node1, int node2) {  
            int find1 = find(node1);
            int find2 = find(node2);
            if(find1 != find2) {
                father[find1] = find2;
                count--;
            }
        }
        public int find (int node) {  
            if (father[node] == node) {  
                return node;
            }
            father[node] = find(father[node]);  
            return father[node];
        }
    }
}
