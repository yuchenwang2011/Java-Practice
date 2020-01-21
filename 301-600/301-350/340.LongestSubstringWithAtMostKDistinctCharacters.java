340. Longest Substring with At Most K Distinct Characters
Hard

Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

Accepted 104,431 Submissions 246,813

Answer:
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        int[] count = new int[256];
        
        int num = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(count[s.charAt(i)]++ == 0) num++;
            if(num > k) {
                while(--count[s.charAt(start++)] > 0);//do nothing
                num--;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
