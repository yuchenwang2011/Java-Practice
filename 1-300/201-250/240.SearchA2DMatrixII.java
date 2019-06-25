240. Search a 2D Matrix II My Submissions QuestionEditorial Solution
Total Accepted: 33578 Total Submissions: 98042 Difficulty: Medium
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/48852/my-concise-o-m-n-java-solution
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null | matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length-1;
        while(col >= 0 && row < matrix.length) {
            int tmp = matrix[row][col];
            if(tmp == target) return true;
            else if(tmp > target) col--;
            else if(tmp < target) row++;
        }
        return false;
    }
}
