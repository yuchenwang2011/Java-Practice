public class Solution {
    //Got inspired by this answer:
    //https://leetcode.com/discuss/92609/three-line-java-solution
    public int[] countBits(int num) {
        if(num <= 0) return new int[]{0};
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
 
        //From my understanding, when shift right a bit, 1111 -> 111, you just need to know how many bits 111 has
        //then plus if the shifted rightmost big whether is 1
        //One more example, 1110 -> 111, you just need to know how many bits 111 has, then plus 
        //whether the shifted right most bit whether is 1
        for(int i = 2; i <= num; i++){
            dp[i] = dp[i >> 1] + (i & 1);   
        }
        return dp;
    }
}
