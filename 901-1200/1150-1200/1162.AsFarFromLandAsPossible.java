1162. As Far from Land as Possible
Medium

Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, 
find a water cell such that its distance to the nearest land cell is maximized and return the distance.
The distance used in this problem is the Manhattan distance: 
the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
If no land or water exists in the grid, return -1.

Example 1:
Input: [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: 
The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:
Input: [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: 
The cell (2, 2) is as far as possible from all the land with distance 4.
 
Note:
1 <= grid.length == grid[0].length <= 100
grid[i][j] is 0 or 1 
Accepted 1,323 Submissions 4,945

Answer:
https://leetcode.com/problems/as-far-from-land-as-possible/discuss/361047/Java-O(MN)-BFS
class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int result = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                //For example, for a water spot which is adjacent to an island, the distance should be 1. 
                //But I record the distance as 2 in the grid. So when we calculating the result we need a minus 1.
                result = Math.max(result, grid[cur[0]][cur[1]] - 1);
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        grid[x][y] = grid[cur[0]][cur[1]] + 1;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        return result == 0 ? -1 : result;
    }
}
