139. Word Break
Medium

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine 
if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

Answer:
//3 solutions, DFS + BFS + DP. Need to know all these 3 methods
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        Set<Integer> invalidIdx = new HashSet<>();
        return helper(s, 0, wordDict, invalidIdx);
    }
    
    public boolean helper(String s, int idx, List<String> wordDict, Set<Integer> invalidIdx){
        if(idx >= s.length()) return true;
        if(invalidIdx.contains(idx)) return false;
        
        for(int i = idx + 1; i <= s.length(); i++){
            String s1 = s.substring(idx, i);
            if(wordDict.contains(s1) && helper(s, i, wordDict, invalidIdx)) {
                return true;     
            }
        }
         //means after this index i, there is no way after this can achieve goal
        invalidIdx.add(idx);
        return false;
    }
}
