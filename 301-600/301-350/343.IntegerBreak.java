343. Integer Break
Medium

Given a positive integer n, break it into the sum of at least two positive integers 
and maximize the product of those integers. Return the maximum product you can get.

Example 1:
Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:
Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.

Accepted 94,478 Submissions 192,193

Answer:
class Solution {
    public int integerBreak(int n) {
        if(n <= 0) return n;
        if(n <= 2) return 1;
        if(n <= 3) return 2;
        int result = 1;
        while(n > 4){
            result *= 3;
            n -= 3;
        }
        return result * n;
    }
}
