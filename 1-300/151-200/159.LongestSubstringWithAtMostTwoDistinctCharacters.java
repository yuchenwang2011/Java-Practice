159. Longest Substring with At Most Two Distinct Characters
Medium

Given a string s , find the length of the longest substring t that contains at most 2 distinct characters.

Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
    
Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
Accepted 86,501 Submissions 179,089
    
Answer:
//尽量用这个人的模板吧，思路差不多
https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int count = 0;
        int length = 0;

        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) count++;
            end++;

            while(count > 2){
                char tmpc = s.charAt(start);
                map.put(tmpc, map.get(tmpc) - 1);
                if(map.get(tmpc) == 0) {
                    count--;
                }
                start++;
            }
            length = Math.max(length, end - start);
        }
        return length;
    }
}
