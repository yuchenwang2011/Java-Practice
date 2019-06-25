298. Binary Tree Longest Consecutive Sequence My Submissions Question
Total Accepted: 5989 Total Submissions: 16664 Difficulty: Medium
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//At first My answer was similar to first link, then I removed the global variable as the second link
//https://leetcode.com/discuss/66584/easy-java-dfs-is-there-better-time-complexity-solution
//https://leetcode.com/discuss/68723/simple-recursive-dfs-without-global-variable
public class Solution {
    public int longestConsecutive(TreeNode root) {
        int count = 0;
        if(root == null) return count;
        return dfs(root, null, count);
    }
    
    public int dfs(TreeNode root, TreeNode prev, int count){
        if(root == null) return 0;
        if (prev == null) count ++;
        else count = (root.val - 1 == prev.val) ? count + 1 : 1;
        int left = dfs(root.left, root, count);
        int right = dfs(root.right, root, count);
        return Math.max(count, Math.max(left, right));
    }
}
