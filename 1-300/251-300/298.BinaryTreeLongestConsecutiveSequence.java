298. Binary Tree Longest Consecutive Sequence My Submissions Question
Total Accepted: 5989 Total Submissions: 16664 Difficulty: Medium
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
   The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

Answer:
class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return helper(root, null, 0);
    }
    
    public int helper(TreeNode root, TreeNode parent, int count){
        if(root == null) return 0;
        if(parent != null && root.val == parent.val + 1) count++;
        else count = 1;
        
        int left = helper(root.left, root, count);
        int right = helper(root.right, root, count);
        return Math.max(count, Math.max(left, right));
    }
}
