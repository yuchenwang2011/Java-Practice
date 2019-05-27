120. Triangle My Submissions Question
Total Accepted: 60262 Total Submissions: 207317 Difficulty: Medium
Given a triangle, find the minimum path sum from top to bottom.
 Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, 
where n is the total number of rows in the triangle.

Answer:
//result:  [4 1 8 3 0]
//result:  [7 6 10]
//result:  [9 10]
//result:  [2]

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //1st link has a very good explanation but i still have a few questions
        //after reading the second one, i'm ok
        //https://leetcode.com/discuss/5337/dp-solution-for-triangle
        //https://leetcode.com/discuss/53694/7-lines-neat-java-solution
        //Test Case: [[-1],[2,3],[1,-1,-3]], 
        if(triangle == null || triangle.isEmpty()) {return Integer.MAX_VALUE;}
        int[] dp = new int[triangle.size()+1]; //for the last line j+1
        for(int i = triangle.size()-1; i>=0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
