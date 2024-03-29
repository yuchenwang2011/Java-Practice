746. Min Cost Climbing Stairs
Easy 10.3K 1.6K

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.

Example 1:
Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.

Example 2:
Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 
Constraints:
2 <= cost.length <= 1000
0 <= cost[i] <= 999
Accepted 919.8K Submissions 1.4M Acceptance Rate 64.1%

Answer:
//from this comment
//https://leetcode.com/problems/min-cost-climbing-stairs/solutions/148907/doubt
						                      __________
				                   ___ | Final step
                 ___ | 20
            ___ | 15
_________ | 10
First step
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int result = 0;
        if(cost == null || cost.length == 0) return result;
        if(cost.length == 1) return cost[0];

        int first = cost[0];
        int second = cost[1];
        for(int i = 2; i < cost.length; i++){
            int current = Math.min(first, second) + cost[i];
            first = second;
            second = current;
        }

	//因为现在second就是result，然后first是之前那一步可以一次走两个台阶，所以在他们之间选择
        return Math.min(first, second);
    }
}
