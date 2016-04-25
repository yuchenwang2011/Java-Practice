342. Power of Four   My Submissions QuestionEditorial Solution
Total Accepted: 6678 Total Submissions: 19909 Difficulty: Easy
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Answer:
public class Solution {
    //Got inspired by this answer:
    //*************Remember this question!!!
    //https://leetcode.com/discuss/97924/o-1-one-line-solution-without-loops
    //http://www.binaryhexconverter.com/hex-to-binary-converter
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        return ((num & (num - 1)) == 0) && ((num & 0x55555555) == num); 
    }
}
