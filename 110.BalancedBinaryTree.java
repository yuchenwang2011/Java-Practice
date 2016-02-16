lanced Binary Tree My Submissions Question
Total Accepted: 96572 Total Submissions: 289031 Difficulty: Easy
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined 
as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
//There are 2 answers of this question, first is mine, O(N^2) time complexity, second is only O(N)
//https://leetcode.com/discuss/22898/the-bottom-up-o-n-solution-would-be-better
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    
    public int getDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(getDepth(root.left)+1,getDepth(root.right)+1);
    }
}

//Second method is actually just did some more during get the depth
public class Solution {
    public boolean isBalanced(TreeNode root) {
        int depth = getHeight(root);
        if(depth == -1) return false;
        return true;
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1) return -1;
        if(leftDepth == -1 || rightDepth == -1) return -1;
        return Math.max(leftDepth,rightDepth)+1;
    }
}
