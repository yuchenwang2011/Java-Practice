91. Decode Ways My Submissions Question
Total Accepted: 65202 Total Submissions: 375300 Difficulty: Medium
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

Answer:
public class Solution {
    //Inspired by these 2 answers, they are pretty the same but first O(N) space, second O(1) space
    //https://leetcode.com/discuss/83547/java-clean-dp-solution-with-explanation
    //https://leetcode.com/discuss/54579/simple-java-solution-with-o-1-space
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0' ) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1; 
        dp[1] = 1; 
        for(int i = 2; i <= s.length(); i++) { 
            //it's very tricky here for i <= s.length()
            int oneStepVal = Integer.parseInt(s.substring(i-1,i));
            int twoStepVal = Integer.parseInt(s.substring(i-2,i));
            if(oneStepVal >= 1 && oneStepVal <=9) dp[i] += dp[i-1];
            if(twoStepVal >= 10 && twoStepVal <=26) dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }
}
