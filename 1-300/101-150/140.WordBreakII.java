140. Word Break II
Hard

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]

Answer:
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return result;
        
        Set<Integer> invalid = new HashSet<>();
        helper(s, wordDict, result, invalid, 0, "");
        return result;
    }
    
    public void helper(String s, List<String> wordDict, List<String> result, Set<Integer> invalid, int idx, String tmp){
        if(idx >= s.length()) {
            result.add(tmp);
            return;
        }
        if(invalid.contains(idx)) return;
        
        int size = result.size();
        for(int i = idx + 1; i <= s.length(); i++){
            String sub = s.substring(idx, i);
            if(!wordDict.contains(sub)) continue;
            if(i == s.length()) {
                helper(s, wordDict, result, invalid, i, tmp + sub);
            } else {
                helper(s, wordDict, result, invalid, i, tmp + sub + " ");
            }
        }
        
        if(result.size() == size) invalid.add(idx);
    }
}
