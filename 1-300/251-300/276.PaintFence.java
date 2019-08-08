276. Paint Fence My Submissions QuestionEditorial Solution
Total Accepted: 7962 Total Submissions: 25857 Difficulty: Easy
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

Answer:
public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        else if (n == 1) return k;
        int dp[] = new int[n];
        dp[0] = k;
        dp[1] = dp[0] * k;
        for(int i = 2; i <n ; i++){
            //你要么跟前一个不同(这种情况你啥都不不需要多操心)，要么就跟前一个相同
            //但是你要和前一个相同的话，你要前两个和前一个他俩是不同的，所以此时前一个的值你需要单独算。
            dp[i] = dp[i-1] * (k-1) + dp[i-2] * (k - 1) * 1;
        }
        return dp[n-1];
    }
}

public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k ==0) return 0;
        else if (n == 1) return k;
        else if (n == 2) return k * k;
        
        int first = k;
        int second = k * k;
        int result = 0;
        for(int i = 2; i < n; i++){
            result = first * (k - 1) + second * (k - 1) * 1;
            first = second;
            second = result;
        }
        return result;
    }
}
