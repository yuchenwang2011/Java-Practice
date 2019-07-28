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

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        //alert! below must be in a bracket
        return (n & (n - 1)) == 0;
    }
}
