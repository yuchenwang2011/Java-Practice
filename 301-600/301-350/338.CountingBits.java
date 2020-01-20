338. Counting Bits   My Submissions QuestionEditorial Solution
Total Accepted: 19214 Total Submissions: 34593 Difficulty: Medium
Given a non negative integer number num. For every numbers i 
in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). 
But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function 
like __builtin_popcount in c++ or in any other language.
Hint:

You should make use of what you have produced already.
Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range from previous.
Or does the odd/even status of the number help you in calculating the number of 1s?

Answer:
//From my understanding, when shift right a bit, 1111 -> 111, you just need to know how many bits 111 has
//then plus if the shifted rightmost big whether is 1
//One more example, 1110 -> 111, you just need to know how many bits 111 has, then plus 
//whether the shifted right most bit whether is 1
class Solution {
    public int[] countBits(int num) {
        if(num < 0) return new int[0];
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
