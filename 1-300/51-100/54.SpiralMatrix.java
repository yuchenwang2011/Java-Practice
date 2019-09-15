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
            //这里是我后改的，其实应该是if(rowStart <= rowEnd)
            //因为for循环里是col的，如果col不合格也就不会执行的，所以就看row合不合格了
            if(rowStart <= rowEnd && colStart <= colEnd){
              for(int i = colEnd; i >= colStart; i--){
                  result.add(matrix[rowEnd][i]);
              }
              rowEnd--;
            }
            
            if(rowStart <= rowEnd && colStart <= colEnd){
              for(int i = rowEnd; i >=rowStart; i--){
                  result.add(matrix[i][colStart]);
              }
              colStart++;
            }
        }
        return result;
    }
}
