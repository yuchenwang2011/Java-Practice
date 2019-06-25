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
//my own solution
class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
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

//And this is the my own implementation
class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        int down = n - 1;
        int right = m - 1;
        int totalStep = down + right;
        double result = 1;
        
        //can use C(9,4) as an example to try to understand
        //right and down, use either one is ok. in math it's the same
        for(int i = 1; i <= right; i++){
            result = result * (totalStep - right + i) / i;
        }
        return (int) result;
    }
}
