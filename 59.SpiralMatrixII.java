59. Spiral Matrix II My Submissions Question
Total Accepted: 46262 Total Submissions: 136711 Difficulty: Medium
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

Answer:
class Solution {
    public int[][] generateMatrix(int n) {
        if(n <= 0) return null;
        int[][] result = new int[n][n];
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        
        int i = 1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int col = colStart; col <= colEnd; col++){
                result[rowStart][col] = i++;
            }
            rowStart++;
            
            for(int row = rowStart; row <= rowEnd; row++){
                result[row][colEnd] = i++;
            }
            colEnd--;
            
            if(rowStart <= rowEnd) {
                for(int col = colEnd; col >= colStart; col--){
                    result[rowEnd][col] = i++;
                }
                rowEnd--;
            }
            
            if(colStart <= colEnd){
                for(int row = rowEnd; row >= rowStart; row--){
                    result[row][colStart] = i++;
                }
                colStart++;
            }
        }
        return result;
    }
}
