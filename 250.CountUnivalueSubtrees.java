250. Count Univalue Subtrees My Submissions Question
Total Accepted: 4878 Total Submissions: 13659 Difficulty: Medium
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.

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
//Inspired by this answer:
//https://leetcode.com/discuss/73746/clean-dfs-solution
public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return count;
    }
    
    public boolean dfs(TreeNode root){
        if(root == null) return true;
        if(root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if(left && right) {
            if((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val ) ){
              count++;
              return true;
            }
        }
        return false;
    }
    
}
