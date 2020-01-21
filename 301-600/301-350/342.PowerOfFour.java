342. Power of Four   My Submissions QuestionEditorial Solution
Total Accepted: 6678 Total Submissions: 19909 Difficulty: Easy
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Answer:
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}

public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        //it is 01010101010101010101010101010101 in binary with a length of 32
        return ((num & (num - 1)) == 0) && ((num & 0x55555555) == num); 
    }
}
