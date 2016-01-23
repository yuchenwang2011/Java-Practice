48. Rotate Image My Submissions Question
Total Accepted: 58086 Total Submissions: 172764 Difficulty: Medium
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

Answer:
public class Solution {
    public void rotate(int[][] matrix) {
        //I was inspired by first answer, my own idea is same as second link
        //https://leetcode.com/discuss/70200/an-clean-and-easy-java-code-with-1ms
        //https://leetcode.com/discuss/70234/share-my-java-submission
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
