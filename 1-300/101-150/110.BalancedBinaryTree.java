lanced Binary Tree My Submissions Question
Total Accepted: 96572 Total Submissions: 289031 Difficulty: Easy
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined 
as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Answer:
//each of the node only accessed once, it's a O(N) solution
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
