124. Binary Tree Maximum Path Sum
Hard

Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes 
from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

Answer:
class Solution {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return result;
    }
    
    public int helper(TreeNode root){
        if(root == null) return 0;
        //if it has negative value, we don't want it
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        result = Math.max(result, left + right + root.val);
        //as long as we want to combine with parent node
        //the path we return should be a straight line
        return Math.max(left, right) + root.val;
    }
}
