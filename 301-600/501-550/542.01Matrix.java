542. 01 Matrix
Medium

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
 
Example 2:
Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
Accepted 61,083 Submissions 162,132

Answer:
//看这个方法就好了，别看我自己的了
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0) return mat;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        int distance = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                for(int[] direction : directions){
                    int x = tmp[0] + direction[0];
                    int y = tmp[1] + direction[1];
                    if(x >= 0 && x < mat.length && y >= 0 && y < mat[0].length && mat[x][y] == -1) {
                        mat[x][y] = distance;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            distance++;
        }

        return mat;
    }
}

//我自己的solution
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) {
                    queue.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] tmp = queue.poll();
                int a = tmp[0];
                int b = tmp[1];
                int c = tmp[2];
                for(int[] direction : directions){
                    int x = a + direction[0];
                    int y = b + direction[1];
                    if(x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] != 0 && !visited[x][y]) {
                        matrix[x][y] = c + 1;
                        queue.offer(new int[]{x, y, matrix[x][y]});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return matrix;
    }
}
