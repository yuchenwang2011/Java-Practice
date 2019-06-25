172. Factorial Trailing Zeroes My Submissions QuestionEditorial Solution
Total Accepted: 55251 Total Submissions: 170197 Difficulty: Easy
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Answer:
public class Solution {
    //Got inspired by this answer, first link for explanation and second for java
    //https://leetcode.com/discuss/19847/simple-c-c-solution-with-detailed-explaination
    //https://leetcode.com/discuss/65458/3-lines-of-java-o-logn-time-o-1-space
    public int trailingZeroes(int n) {
        if(n <= 4) return 0;
        int sum = 0;
        while(n >= 5){
            sum = sum + n/5;
            n = n / 5;
        }
        return sum;
    }
}
