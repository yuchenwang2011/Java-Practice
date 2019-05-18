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
//for the given example, try calculate by yourself the left, right, height, result values
example:
1 0 1 0 0 
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
  
height:
1 0 1 0 0
2 0 2 1 1 
3 1 3 2 2
4 0 0 3 0
  
left:
0 0 2 0 0
0 0 2 2 2
0 0 2 2 2
0 0 0 3 0
  
right:
1 5 3 5 5
1 5 3 5 5
1 5 3 5 5
1 5 5 4 5
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


class Solution {
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        
        int[] height = new int[matrix[0].length + 1];
        for(int i = 0; i < matrix.length; i++){
            Deque<Integer> stack = new ArrayDeque<>();
            
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            
            for(int j = 0; j < height.length; j++){
                int currentHeight = height[j];
                while(!stack.isEmpty() && height[stack.peek()] > currentHeight){
                    int top = stack.pop();
                    int length = stack.isEmpty()? j : (j - 1 - stack.peek());
                    result = Math.max(result, height[top] * length);
                }
                stack.push(j);
            }
        }
        return result;
    }
}
