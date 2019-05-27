115. Distinct Subsequences
Hard

Given a string S and a string T, count the number of distinct subsequences of S which equals T.
A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. 
  (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:
Input: S = "rabbbit", T = "rabbit"
Output: 3

Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^

Example 2:
Input: S = "babgbag", T = "bag"
Output: 5

Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
    
    
//Answer
  N r a b b i t
N 1 0 0 0 0 0 0
r 1 1 0 0 0 0 0
a 1 1 1 0 0 0 0
b 1 1 1 1 0 0 0
b 1 1 1 2 1 0 0 
b 1 1 1 3 3 0 0
i 1 1 1 3 3 3 0 
t 1 1 1 3 3 3 3

class Solution {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() == 0) return 0;
        int[][] result = new int[s.length() + 1][t.length() + 1];
        result[0][0] = 1;
        for(int i = 1; i < result.length; i++){
            result[i][0] = 1;
        }
        
        for(int i = 1; i < result[0].length; i++){
            result[0][i] = 0;
        }
        
        for(int i = 1; i < result.length; i++){
            for(int j = 1; j < result[0].length; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
