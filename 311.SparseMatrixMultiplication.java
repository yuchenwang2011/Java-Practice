311. Sparse Matrix Multiplication My Submissions QuestionEditorial Solution
Total Accepted: 4988 Total Submissions: 10547 Difficulty: Medium
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |

Answer:
//This answer is TLE, but i think this is worthy to be recorded. 
public class Solution {
    //I got the hard way to calcualte the multiplication
    //http://stackoverflow.com/questions/17623876/matrix-multiplication-using-arrays
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null) return null;
        int aRow = A.length;
        int aCol = A[0].length;
        int bRow = B.length;
        int bCol = B[0].length;
        int[][] result = new int[aRow][bCol];
        
        for(int i = 0; i < aRow; i++){
            for(int j = 0; j < bCol; j++){
                for(int k = 0; k < aCol; k++){
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null) return null;
        int aRow = A.length;
        int aCol = A[0].length;
        int bRow = B.length;
        int bCol = B[0].length;
        
        if(aCol != bRow) return null;
        int[][] C = new int[aRow][bCol];
        
        for(int i = 0; i <aRow; i++){
            for(int k = 0; k < aCol; k++){
                if(A[i][k] != 0){
                    for(int j = 0; j < bCol; j++){
                        if(B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }
}
