191. Number of 1 Bits   My Submissions QuestionEditorial Solution
Total Accepted: 87772 Total Submissions: 233826 Difficulty: Easy
Write a function that takes an unsigned integer and returns the number 
of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 
00000000000000000000000000001011, so the function should return 3.

Answer:
public class Solution {
    //This is a website you must read about bit manipulation as a beginner
    //http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
    // you need to treat n as an unsigned value
    //************Remember how to deal with unsigned value in java
    //https://leetcode.com/discuss/30605/simple-java-solution-bit-shifting
    public int hammingWeight(int n) {
        int ones = 0;
        while(n != 0) {
            if( (n & 1) != 0) ones++;
            n = n >>> 1;
        }
        return ones;
    }
}
