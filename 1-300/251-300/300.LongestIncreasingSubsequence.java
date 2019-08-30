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


tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6
We can easily prove that tails is a increasing array. Therefore it is possible to do a binary search 
in tails array to find the one needs update.

Each time we only do one of the two:

(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i]
Doing so will maintain the tails invariant. The the final answer is just the size.
    
https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}

Just explain more about the tail processing example, based on https://segmentfault.com/a/1190000003819886

[1,3,5,2,8,4,6]
For this list, we can have LIS with different length.
For length = 1, [1], [3], [5], [2], [8], [4], [6], we pick the one with smallest tail element as the representation of length=1, which is [1]
For length = 2, [1,2] [1,3] [3,5] [2,8], ...., we pick [1,2] as the representation of length=2.
Similarly, we can derive the sequence for length=3 and length=4
The result sequence would be:
len=1: [1]
len=2: [1,2]
len=3: [1,3,4]
len=4: [1,3,5,6]

According to the logic in the post,we can conclude that:
(1) If there comes another element, 9
We iterate all the sequences, found 9 is even greater than the tail of len=4 sequence, we then copy len=4 sequence to be a new sequece, and append 9 to the new sequence, which is len=5: [1,3,5,6,9]
The result is:
len=1: [1]
len=2: [1,2]
len=3: [1,3,4]
len=4: [1,3,5,6]
len=5: [1,3,5,6,9]

(2) If there comes another 3,
We found len=3 [1,3,4], whose tailer is just greater than 3, we update the len=3 sequence tobe [1,3,3]. The result is:
len=1: [1]
len=2: [1,2]
len=3: [1,3,3]
len=4: [1,3,5,6]

(3) If there comes another 0,
0 is smaller than the tail in len=1 sequence, so we update the len=1 sequence. The result is:
len=1: [0]
len=2: [1,2]
len=3: [1,3,3]
len=4: [1,3,5,6]
