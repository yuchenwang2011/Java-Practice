300. Longest Increasing Subsequence My Submissions QuestionEditorial Solution
Total Accepted: 24448 Total Submissions: 71466 Difficulty: Medium
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

Answer:
//Got inspired by this answer: time complexity O(N^2)
//https://www.youtube.com/watch?v=CE2b_-XfVDk
//[3,4,-1,0,6,1,2] result is -1 0 1 2 => 4
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int result = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(dp[i], result);
        }
        
        return result;
    }
}

public class Solution {
    //This is the most difficult question I have ever seen so far, must read the following explanation
    //http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    //https://leetcode.com/discuss/67546/share-java-o-n-logn-solution
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        int tailLength = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < tails[0]) tails[0] = nums[i]; //equals to create a new list
            else if(nums[i] > tails[tailLength - 1]) {
                tails[tailLength] = nums[i];
                tailLength ++;
            } else {
                //To search where nums[i] should locate to replace the old one
                int replacePosition = binarySearch(tails, 0, tailLength - 1, nums[i]);
                tails[replacePosition] = nums[i];
            }
        }
        return tailLength;
    }
    
    public int binarySearch(int[] tails, int start, int end, int key){
        if(tails == null || tails.length == 0) return -1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(tails[mid] == key) return mid;
            else if(tails[mid] < key) start = mid;
            else end = mid;
        }
        return end;
    }
}
