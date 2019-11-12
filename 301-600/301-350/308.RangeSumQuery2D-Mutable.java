308. Range Sum Query 2D - Mutable
Hard

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined 
by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1)
and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10

Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
Accepted 40,512 Submissions 121,049

Answer:
//https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/75870/
//Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms
class NumMatrix {
    //time should be O(log(m) * log(n))
    private int[][] nums;
    private int[][] tree;
    private int row;
    private int col;
    
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        row = matrix.length;
        col = matrix[0].length;
        nums = new int[row][col];
        tree = new int[row + 1][col + 1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for(int i = row + 1; i < tree.length; i += lowbit(i)){
            for(int j = col + 1; j < tree[0].length; j += lowbit(j)){
                tree[i][j] += diff;
            }
        }
    }
    
    public int lowbit(int i){
        return i & (-i);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 < 0 || row2 < 0 || row1 >= row || row2 >= row) return 0;
        if(col1 < 0 || col2 < 0 || col1 >= col || col2 >= col) return 0;
        return sum(row2 + 1, col2 + 1) - sum(row2 + 1, col1) - sum(row1, col2 + 1) + sum(row1, col1);
    }
    
    public int sum(int m, int n){
        int sum = 0;
        for(int i = m; i > 0; i -= lowbit(i)){
            for(int j = n; j > 0; j -= lowbit(j)){
                sum += tree[i][j];
            }
        }
        return sum;
    }
}
