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
public class Solution {
    public int[][] generateMatrix(int n) {
        //Still use the method of 
        //https://leetcode.com/discuss/14079/my-super-simple-solution-can-used-for-both-spiral-matrix-and
        int[][] result = new int[n][n];
        if(n <=0){
            return result;
        }
        int rowStart = 0, colStart = 0;
        int rowEnd = n-1, colEnd = n-1;
        int value = 1;
        while(value <= n*n){
            for(int i = colStart; i <= colEnd; i++){
                result[rowStart][i] = value;
                value++;
            }
            rowStart++;
            
            for(int i = rowStart; i <= rowEnd; i++){
                result[i][colEnd] = value;
                value++;
            }
            colEnd--;
            
            //if(rowStart <= rowEnd){
                for(int i = colEnd; i >= colStart; i--){
                    result[rowEnd][i] = value;
                    value++;
                }
            //}
            rowEnd--;
            
            //if(colStart <= colEnd){
                for(int i = rowEnd; i >= rowStart; i--){
                    result[i][colStart] = value;
                    value++;
                }
            //}
            colStart++;
        }
        return result;
    }
}
