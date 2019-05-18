85. Maximal Rectangle
Hard

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:
Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6

Answer:
//自己多跑几个例子
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];
        Arrays.fill(right, col);
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            
            int firstLeft = 0;
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(firstLeft, left[j]);
                } else {
                    left[j] = 0;
                    firstLeft = j + 1;
                }
            }
            
            int firstRight = col;
            for(int j = col - 1; j >= 0; j--){
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(firstRight, right[j]);
                } else {
                    right[j] = col;
                    firstRight = j;
                }
            }
            
            for(int j = 0; j < col; j++){
                int area = (right[j] - left[j]) * height[j];
                result = Math.max(result, area);
            }
        }
        return result;
    }
}
