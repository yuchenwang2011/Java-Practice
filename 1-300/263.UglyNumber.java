263. Ugly Number My Submissions QuestionEditorial Solution
Total Accepted: 50267 Total Submissions: 138269 Difficulty: Easy
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.

Answer:
public class Solution {
    public boolean isUgly(int num) {
        //Got inspired by this answer, my idea at first was to put in a big while(%2 %3 %5) then 3 if conditions
        //https://leetcode.com/discuss/53846/simplest-java-solution
        if(num <= 0) return false;
        while(num % 2 == 0) num /= 2;
        while(num % 3 == 0) num /= 3;
        while(num % 5 == 0) num /= 5;
        return num == 1;
    }
}
