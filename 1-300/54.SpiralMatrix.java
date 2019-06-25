54. Spiral Matrix My Submissions Question
Total Accepted: 50822 Total Submissions: 232246 Difficulty: Medium
Given a matrix of m x n elements (m rows, n columns), 
return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

Answer: 
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //I got inspired by this answer
        //https://leetcode.com/discuss/12228/super-simple-and-easy-to-understand-solution
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length ==0){
            return result;
        }
        int rowStart = 0, rowEnd = matrix.length-1;
        int colStart = 0, colEnd = matrix[0].length-1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart; i <= colEnd; i++){
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++){
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            //cautions here! rowStart and colEnd have changed
            if(rowStart <= rowEnd){
              for(int i = colEnd; i >= colStart; i--){
                  result.add(matrix[rowEnd][i]);
              }
              rowEnd--;
            }
            //it can be put outside
            //rowEnd--;
            
            if(colStart <= colEnd){
              for(int i = rowEnd; i >=rowStart; i--){
                  result.add(matrix[i][colStart]);
              }
              colStart++;
            }
            //colStart++;
        }
        return result;
    }
}
