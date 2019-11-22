317. Shortest Distance from All Buildings
Hard

You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. 
You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.

Example:
Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7 

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

Accepted 51,887 Submissions 131,335

Answer:
//O(m^2*n^2), 一开始是俩for,所以m*n. 后来helper里最差情况就是一个点一直把所有其他点都循环遍了
class Solution {
    private int[][] directions = new int[][]{{0, 1},{0, -1},{-1, 0},{1,0}};
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        int buildings = 0;
        int[][] distances = new int[m][n]; //the total distance to reach all 1s for i, j
        int[][] nums = new int[m][n];      //the total buildings for i, j, able to reach
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) {
                    buildings++;
                    helper(grid, distances, nums, i, j);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && nums[i][j] == buildings && distances[i][j] != 0) {
                    result = Math.min(result, distances[i][j]);   
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    public void helper(int[][] grid, int[][] distances, int[][] nums, int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int distance = 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++; //每轮一圈肯定就distance+1了
            for(int i = 0; i < size; i++){
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                for(int[] direction : directions){
                    int a = x + direction[0];
                    int b = y + direction[1];
                    if(a >= 0 && b >= 0 && a < grid.length && b < grid[0].length && !visited[a][b] && grid[a][b] == 0) {
                        visited[a][b] = true;
                        queue.offer(new int[]{a, b});
                        distances[a][b] += distance;
                        nums[a][b]++; 
                    }
                }
            }
        }
    }
}
