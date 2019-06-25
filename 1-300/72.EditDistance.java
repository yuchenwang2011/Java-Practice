72. Edit Distance
Hard
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

Answer:
//my own example below the code is from video
"abc"
"aef"
ps: the n means from null to abc, null to aef, needs 3, null to a needs1
null to be needs 2
  n a e f  
n 0 1 2 3
a 1 0 1 2
b 2 1 1 2
c 3 2 2 2

insert:  dp[i][j] = dp[i][j-1] + 1;
delete:  dp[i][j] = dp[i-1][j] + 1;
replace: dp[i][j] = dp[i-1][j-1] + 1

class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null) return 0;
        if(word1 == null || word1.length() == 0) return word2.length();
        if(word2 == null || word2.length() == 0) return word1.length();
        
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = i;
        }
        
        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = i;
        }
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                //alert, this i and j means dp, not word1 and word2
                char a = word1.charAt(i - 1);
                char b = word2.charAt(j - 1);
                if(a == b){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
}

