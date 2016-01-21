73. Set Matrix Zeroes My Submissions Question
Total Accepted: 56875 Total Submissions: 174124 Difficulty: Medium
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

Answer:
//test case: [[0,1]], [[1,0]], [[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
public class Solution {
    public void setZeroes(int[][] matrix) {
        //Got inspired by the answer in the second floor
        //https://leetcode.com/discuss/1650/is-there-a-better-constant-space-solution
        //********Remember how to get the row and column for a 2d matrix!!
        int row = matrix.length, column = matrix[0].length;
        if(matrix == null || row == 0 || column == 0){
            return;
        }
        
        boolean setFirstColumnZero = false, setFirstRowZero = false;
        for(int i = 0; i < column; i++){
            if(matrix[0][i] == 0){ setFirstRowZero = true;break;}
        }
        for(int i =0; i< row; i++) {
            if(matrix[i][0] == 0){ setFirstColumnZero = true;break;}
        }
        
        for(int i = 0 ; i < row; i++){
            for(int j = 0; j < column; j++){
                if(matrix[i][j]==0){matrix[0][j] = 0; matrix[i][0] =0;}
            }
        }
        //set zero except the first row and first column
        for(int i = 1; i< row; i++){
            for(int j =1; j < column; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){matrix[i][j]=0;}
            }
        }
        if(setFirstRowZero == true){
            for(int i = 0; i < column ; i++) {matrix[0][i] = 0;}
        }
        if(setFirstColumnZero == true) {
            for(int i = 0; i < row; i++) {matrix[i][0] = 0;}
        }
    }
}
