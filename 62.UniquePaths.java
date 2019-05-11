i62. Unique Paths My Submissions Question
Total Accepted: 73839 Total Submissions: 211475 Difficulty: Medium
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
oxxxxxx
xxxxxxx
xxxxxxo
Above is a 3 x 7 grid. How many possible unique paths are there?
Note: m and n will be at most 100.

Answer: 
public class Solution {
    public int uniquePaths(int m, int n) {
        //there is a calculation method to use permutation and combinations, here are two website explaining them
        //https://www.mathsisfun.com/combinatorics/combinations-permutations.html
        //http://math.stackexchange.com/questions/208377/combination-with-repetitions
        //such as 3*4, there will be 5 steps to go from start to end, in which 2 steps to go down
        //so the result = C(5,2)=5!/(2!*(5-2)!)=5*4/2=10
        //I will use Dynamic Programming to solve this problem
        //*******Remember the syntax to create a 2d array
        if(m*n ==0){
            return 0;
        }
        int[][] result = new int[m][n];
        for(int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        for(int i = 0; i< m; i++){
            result[i][0] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i][j-1] + result[i-1][j]; 
            }
        }
        return result[m-1][n-1];
    }
}

//this is an optimized method from space complexity O(M*N) -> O(N)
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m*n ==0){
            return 0;
        }
        int[] dp = new int[n]; 
        dp[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j =0; j < n; j++){
                if(j==0){
                  dp[j] = 1;
                } else {
                  dp[j] = dp[j-1]+dp[j];
                }
            }
        }
        return dp[n-1];
    }
}

//New math solution!
//https://leetcode.com/problems/unique-paths/discuss/22981/My-AC-solution-using-formula
int uniquePaths(int m, int n) {
            int N = n + m - 2;// how much steps we need to do
            int k = m - 1; // number of steps that need to go down
            double res = 1;
            // here we calculate the total possible path number 
            // Combination(N, k) = n! / (k!(n - k)!)
            // reduce the numerator and denominator and get
            // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
            for (int i = 1; i <= k; i++)
                res = res * (N - k + i) / i;
            return (int)res;
        }
