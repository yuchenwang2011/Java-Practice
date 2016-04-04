202. Happy Number My Submissions QuestionEditorial Solution
Total Accepted: 61400 Total Submissions: 169856 Difficulty: Easy
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

Answer:
public class Solution {
    //Here is the proof of this question
    //https://leetcode.com/discuss/71625/explanation-those-posted-algorithms-mathematically-valid
    //Got inspired by this method, I will try the second method next round
    //https://leetcode.com/discuss/59684/beat-easy-understand-java-solution-with-brief-explanation
    //https://leetcode.com/discuss/33055/my-solution-in-c-o-1-space-and-no-magic-math-property-involved
    public boolean isHappy(int n) {
        n = Math.abs(n);
        if(n == 0) return false;
        if(n == 1) return true;
        HashSet<Integer> set = new HashSet<Integer>();
        while(n != 1) {
            if(set.add(n) == false) return false;
            int next = 0;
            while(n > 0){
                next = next + (int) Math.pow(n%10,2);
                n = n/10;
            }
            n = next;
        }
        return true;
    }
}
