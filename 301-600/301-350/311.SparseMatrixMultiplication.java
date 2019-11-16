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
class Solution {
    //https://github.com/yuchenwang2011/Java-Practice/blob/master/301-600/301-350/311.gif
    //https://patentimages.storage.googleapis.com/EP0480825A2/imgb0053.png
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int rowB = B.length;
        int colB = B[0].length;
        if(colA != rowB) return new int[0][0];
        
        int[][] result = new int[rowA][colB];
        for(int i = 0; i < rowA; i++){
            for(int k = 0; k < colA; k++){
                if(A[i][k] == 0) continue;
                for(int j = 0; j < colB; j++){
                    if(B[k][j] == 0) continue;
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
