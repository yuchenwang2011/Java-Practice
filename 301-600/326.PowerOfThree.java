326. Power of Three My Submissions QuestionEditorial Solution
Total Accepted: 32175 Total Submissions: 89366 Difficulty: Easy
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

Answer:
public class Solution {
    //Got inspired by this answer:
    //https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
    //http://stackoverflow.com/questions/9898512/how-to-test-if-a-double-is-an-integer
    //http://www.purplemath.com/modules/logrules5.htm
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        return (Math.log10(n) / Math.log10(3)) % 1 ==0;
    }
}
