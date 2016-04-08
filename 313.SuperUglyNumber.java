313. Super Ugly Number My Submissions QuestionEditorial Solution
Total Accepted: 11660 Total Submissions: 34677 Difficulty: Medium
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose 
all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of 
the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/72835/108ms-easy-to-understand-java-solution
    //https://leetcode.com/discuss/81411/java-three-methods-23ms-58ms-with-heap-performance-explained
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n<=0 || primes == null || primes.length == 0) return 0;
        int[] ugly = new int[n];
        int[] index = new int[primes.length];
        ugly[0] = 1;
        
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            
            for(int j = 0; j < index.length; j++){
                min = Math.min(min, primes[j] * ugly[index[j]]);
            }
            ugly[i] = min;
            
            
            for(int j = 0; j < index.length; j++){
                if(ugly[i] >=  primes[j] * ugly[index[j]]) index[j]++;
            }
        }
        return ugly[n-1];
    }
}
