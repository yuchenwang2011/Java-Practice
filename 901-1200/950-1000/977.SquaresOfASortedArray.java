977. Squares of a Sorted Array
Easy

Given an array of integers A sorted in non-decreasing order, 
return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 
Note:
1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.
Accepted 120,349 Submissions 167,653

Answer:
class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            long val = A[i] * A[i];
            A[i] = val > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) val;
        }
        Arrays.sort(A);
        return A;
    }
}