264. Ugly Number II My Submissions QuestionEditorial Solution
Total Accepted: 27313 Total Submissions: 99167 Difficulty: Medium
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

1. The naive approach is to call isUgly for every number until you reach the nth one. 
Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
2. An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
3. The key is how to maintain the order of the ugly numbers. 
Try a similar approach of merging from three sorted lists: L1, L2, and L3.
4. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

Answer:
class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 1) return n;
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        for(int i = 1; i < n; i++){
            ugly[i] = Math.min(ugly[idx2] * 2, Math.min(ugly[idx3] * 3, ugly[idx5] * 5));
            if(ugly[i] == ugly[idx2] * 2) idx2++;
            if(ugly[i] == ugly[idx3] * 3) idx3++;
            if(ugly[i] == ugly[idx5] * 5) idx5++;
        }
        return ugly[n - 1];
    }
}
