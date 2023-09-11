994. Rotting Oranges
Easy

In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Note:
1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
Accepted 35,106 Submissions 75,280

Answer:
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int result = 0;
        int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] current = queue.poll();
                for(int[] direction : directions){
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];
                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            result++;
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        //why count need to be reduce by one?
        //Because we do count++ every time when queue is not empty. When there is no fresh orange, 
        //it still does count++ at the begin of the while loop.
        //why result is 0 and why when it is 0 we need return 0? it is because for such as [[0]], 题里例子写的
        //如果一开始里面就已经没有好橘子了，那就return 0
        return result == 0 ? 0 : result - 1;
    }
}
