201. Bitwise AND of Numbers Range   My Submissions QuestionEditorial Solution
Total Accepted: 33137 Total Submissions: 109183 Difficulty: Medium
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

Answer:
public class Solution {
    //Got inspired and understand by this answer
    //https://leetcode.com/discuss/32115/bit-operation-solution-java
    public int rangeBitwiseAnd(int m, int n) {
        if(m > n) return 0;
        //as long as m != n, there are at least 2 numbers inclusively in between
        //that means at least a 1 and a 0 in between, so the and result is 0 certainly
        int count = 0;
        while(m != n){
            m = m >> 1;
            n = n >> 1;
            count++;
        }
        return n << count;
    }
}
