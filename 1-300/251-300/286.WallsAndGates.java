286. Walls and Gates   My Submissions QuestionEditorial Solution
Total Accepted: 8662 Total Submissions: 23234 Difficulty: Medium
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 
to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  
  Answer:
  public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/60179/java-bfs-solution-o-mn-time
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length ==0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        //先把0附近的INF干掉，这样最近的一批房间全都没了
        //再把这批房间附近的INF也干掉。如此循环，所有能通过INF到达gate的房间都没了
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int row = position[0];
            int col = position[1];
            //上边是不是房间，是就+1，同时把这个房间存起来，因为房间是相同的
            if(row >= 1 && rooms[row-1][col] == Integer.MAX_VALUE) {
                rooms[row-1][col] = rooms[row][col] + 1;
                queue.offer(new int[]{row-1, col});
            }
            //下面是不是房间
            if(row < rooms.length -1 && rooms[row+1][col] == Integer.MAX_VALUE) {
                rooms[row+1][col] = rooms[row][col] + 1;
                queue.offer(new int[]{row+1,col});
            }
            //左边是不是房间
            if(col >=1 && rooms[row][col-1] == Integer.MAX_VALUE) {
                rooms[row][col-1] = rooms[row][col] + 1;
                queue.offer(new int[]{row,col-1});
            }
            //右边是不是房间
            if(col < rooms[0].length -1 && rooms[row][col+1] == Integer.MAX_VALUE){
                rooms[row][col+1] = rooms[row][col] + 1;
                queue.offer(new int[]{row,col+1});
            }
        }
    }
}
