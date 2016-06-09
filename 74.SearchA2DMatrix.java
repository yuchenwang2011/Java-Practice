74. Search a 2D Matrix My Submissions Question
Total Accepted: 67937 Total Submissions: 205832 Difficulty: Medium
Write an efficient algorithm that searches for a value in an m x n matrix. 
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

Answer:
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //My first solution was O(M*logN) that's not right, some people has O(logM+logN)
        //I think this O(logN) is the best solution
        //https://leetcode.com/discuss/15379/binary-search-on-an-ordered-matrix
        boolean result = false;
        int row = matrix.length, column = matrix[0].length;
        if(matrix == null || row == 0 || column == 0){
            return result;
        }
        int start = 0, end = row*column-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int midValue = matrix[mid/column][mid%column];
            if(target == midValue){
                result = true;
                return result;
            } else if(target < midValue){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return result;
    }
}

//this is my second round answer
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row * col - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            int val = matrix[mid/col][mid % col];
            if(val == target) return true;
            else if (val > target) end = mid;
            else start = mid;
        }
        if(matrix[start/col][start % col] == target) return true;
        if(matrix[end/col][end % col] == target) return true;
        return false;
    }
}
