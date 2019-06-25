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
    //"pineapplepenapple"
    //["apple","pen","applepen","pine","pineapple"]
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return result;
        Set<Integer> invalidIdx = new HashSet<>();
        helper(s, wordDict, 0, result, invalidIdx, "");
        return result;
    }
    
    public void helper(String s, List<String> wordDict, int idx, List<String> result, Set<Integer> invalidIdx, String tmp){
        if(idx >= s.length()) {
            //System.out.println("added tmp: " + tmp);
            result.add(tmp); 
            return;
        }
        if(invalidIdx.contains(idx)) {
            //System.out.println("idx is: " + idx + " invalid");
            return;
        }
        int size = result.size();
        for(int i = idx + 1; i <= s.length(); i++){
            String s1 = s.substring(idx, i);
            //System.out.println(s1 + " i is: " + i);
            if(wordDict.contains(s1)) {
                if(i == s.length()) {
                    //System.out.println("first == i is" + i);
                    helper(s, wordDict, i, result, invalidIdx, tmp + s1);
                    return;
                } else {
                    //System.out.println("second == i is" + i);
                    helper(s, wordDict, i, result, invalidIdx, tmp + s1 + " ");
                }
            }
        }
        //System.out.println("finished one circle idx is: " + idx);
        if(size == result.size()) invalidIdx.add(idx);
    }
}
