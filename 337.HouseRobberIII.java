337. House Robber III   My Submissions QuestionEditorial Solution
Total Accepted: 9266 Total Submissions: 24962 Difficulty: Medium
The thief has found himself a new place for his thievery again. 
There is only one entrance to this area, called the "root." 
Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

Answer:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Got inspired by this answer:
 //https://leetcode.com/discuss/91597/easy-understanding-solution-with-dfs
public class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] result = process(root);
        return Math.max(result[0], result[1]);
    }
    
    //num[0] is the max value while rob this node, num[1] is max value while not rob this value
    public int[] process(TreeNode root){
        if(root == null) return new int[2];
        int[] left = process(root.left);
        int[] right = process(root.right);
        int[] result = new int[2];
        result[0] = left[1] + right[1] + root.val;
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    } 
}
