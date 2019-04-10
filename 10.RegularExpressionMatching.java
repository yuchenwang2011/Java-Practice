10. Regular Expression Matching
Hard
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial)

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:
Input: s = "aa"  p = "a"  Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa"  p = "a*"  Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab"  p = ".*"  Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input:  s = "aab"  p = "c*a*b"   Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:
Input:  s = "mississippi"  p = "mis*is*p*."  Output: false

Solution:
https://www.youtube.com/watch?v=l3hda49XcDE
https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation

class Solution {
    public boolean isMatch(String s, String p) {
        if(p == null || s == null) return false;
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        result[0][0] = true;
        for(int i = 1; i < result[0].length; i++){
            if(p.charAt(i - 1) == '*'){
                result[0][i] = result[0][i-2];
            }
        }
        
        for(int i = 1; i < result.length; i++){
            for(int j = 1; j < result[0].length; j++){
                char a = s.charAt(i - 1);
                char b = p.charAt(j - 1);
                if(a == b || b == '.'){
                    result[i][j] = result[i - 1][j - 1];
                } else if(j >= 2 && b == '*'){
                    result[i][j] = result[i][j-2];
                    if(a == p.charAt(j - 2) || p.charAt(j -2) == '.'){
                        //the last || result[i][j-1] is not necessary
                        result[i][j] = result[i][j] || result[i - 1][j] || result[i][j-1];
                    }
                } else {
                    result[i][j] = false;
                }
            }
        }
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] ? 1 : 0);
            }
            System.out.println("");
        }
        return result[s.length()][p.length()];
    }
}
