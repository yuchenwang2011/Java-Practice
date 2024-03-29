392. Is Subsequence
Easy 8.2K 450

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) 
of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
 
Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 
Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, 
and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
Accepted 977.6K Submissions 2.1M Acceptance Rate 47.2%

Answer:
//my own solution
//can be shorten check https://leetcode.com/problems/is-subsequence/solutions/2701674/5-liner-solution-in-java-python-c-beats-100-easy-to-understand/
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;
        if(s.length() > t.length()) return false;

        int sIdx = 0;
        for(int i = 0; i < t.length(); i++){
            if(sIdx >= s.length()) { //这个判定放到前面和后面都行
                return true;
            }
            char currentT = t.charAt(i);
            char currentS = s.charAt(sIdx);
            if(currentT == currentS) {
                sIdx++;
            }
        }
        return sIdx == s.length();
    }
}
