97. Interleaving String
Hard

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false


class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        boolean[][] result = new boolean[s1.length() + 1][s2.length() + 1];
        result[0][0] = true;
        
        for(int i = 1; i < result.length; i++){
            result[i][0] = result[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        for(int i = 1; i < result[0].length; i++){
            result[0][i] = result[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        for(int i = 1; i < result.length; i++){
            for(int j = 1; j < result[0].length; j++){
                boolean first = result[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                boolean second = result[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1); 
                result[i][j] = first || second;
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
