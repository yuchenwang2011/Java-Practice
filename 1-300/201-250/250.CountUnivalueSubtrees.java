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
class Solution {
    private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }
    public boolean helper(TreeNode root){
        if(root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(left != right) return false;
        else {
            if(root.left != null && root.left.val != root.val) return false;
            if(root.right != null && root.right.val != root.val) return false;
            count++;
        }
        return true;
    }
}
