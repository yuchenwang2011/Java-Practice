111. Minimum Depth of Binary Tree My Submissions Question
Total Accepted: 93683 Total Submissions: 310235 Difficulty: Easy
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
//Same idea as mine but a little better
//https://leetcode.com/discuss/76318/very-easy-with-recursion-1ms-java-solution
//There's another BFS solution very interesting, the first reply
//https://leetcode.com/discuss/6308/my-solution-used-level-order-traversal
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else if (root.left != null && root.right == null) return minDepth(root.left)+1; 
        else if (root.right != null && root.left == null) return minDepth(root.right)+1;
        else return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
