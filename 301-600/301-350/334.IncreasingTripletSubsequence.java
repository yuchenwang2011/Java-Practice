334. Increasing Triplet Subsequence
Medium

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
Formally the function should:

Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:
Input: [1,2,3,4,5]
Output: true

Example 2:
Input: [5,4,3,2,1]
Output: false

Accepted 120,591 Submissions 303,101

Answer:
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int n: nums){
            if(n <= min) min = n; //found i
            else if (n <= secondMin) secondMin = n; //found j
            else return true; //found the k
        }

        return false;
    }
}
