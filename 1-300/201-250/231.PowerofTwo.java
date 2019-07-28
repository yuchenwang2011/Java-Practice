231. Power of Two My Submissions QuestionEditorial Solution
Total Accepted: 65098 Total Submissions: 180545 Difficulty: Easy
Given an integer, write a function to determine if it is a power of two.

Answer:
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        while(n != 1){
            if(n % 2 != 0) return false;
            n = n >> 1;
        }
        return true;
    }
}

public class Solution {
    public boolean isPowerOfTwo(int n) {
        //because if is power of two, it should has only 1 zero in the start of the number, in binary
        return n > 0 && (n & (n-1) ) == 0;
    }
}
