48. Rotate Image My Submissions Question
Total Accepted: 58086 Total Submissions: 172764 Difficulty: Medium
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

Answer:
public class Solution {
    public void rotate(int[][] matrix) {
        //这个方法是先以一整行为单位，从头到尾颠倒一下。然后在对称的沿中线颠倒一下。
        int row = matrix.length, column = matrix[0].length;
        if(matrix == null || row != column || row == 0){
            return;
        }
        int start = 0, end = row-1;
        while(start <= end){
            int[] tmpRow = new int[column];
            tmpRow = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = tmpRow;
            start ++; end--;
        }
        
        for(int i = 0; i < row; i++){
            for(int j = i; j < column; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp; 
            }
        }
    }
}

//https://leetcode.com/problems/rotate-image/discuss/18879/AC-Java-in-place-solution-with-explanation-Easy-to-understand.
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        int m = matrix[0].length;
        if(m != n) return;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < m; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for(int i = 0; i < m; i++){
            int start = 0;
            int end = n - 1;
            while(start < end){
                int tmp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = tmp;
                start++;
                end--;
            }
        }
    }
}
