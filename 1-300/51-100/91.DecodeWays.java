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
//记住一旦碰上这种题，先稳住，把dp解法做出来，再优化，不然可能一下就迷糊了
public class Solution {
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

public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n1 = 1, n2 = 1, n3 = 0;
        for(int i = 2; i <= s.length(); i++){
            n3 = 0;
            int oneStepVal = Integer.parseInt(s.substring(i-1,i));
            int twoStepVal = Integer.parseInt(s.substring(i-2,i));
            if(oneStepVal >= 1 && oneStepVal <= 9) n3 += n2;
            if(twoStepVal >= 10 && twoStepVal <=26) n3 += n1;
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }
}

//my O(1) solution May 22 2019
class Solution {
    public int numDecodings(String s) {
        int result = 0;
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return result;
        
        int first = 1;
        int second = 1;
        result = second;
        for(int i = 1; i < s.length(); i++){
            result = 0;
            int val = s.charAt(i) - '0';
            if(val >= 1 && val <= 9) result += second;
            
            val += (s.charAt(i - 1) - '0') * 10;
            if(val >= 10 && val <= 26) result += first;
            first = second;
            second = result;
        }
        return result;
    }
}
