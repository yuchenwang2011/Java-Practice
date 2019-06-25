333. Largest BST Subtree My Submissions Question
Total Accepted: 1342 Total Submissions: 5130 Difficulty: Medium
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Hint:

You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?

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
//I will first use this O(N^2) method to solve, because i don't understand other methods
//I will do them in the next round
//https://leetcode.com/discuss/86535/clean-and-easy-to-understand-java-solution
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE)) return countNode(root);
        return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
    }
    
    public boolean isBST(TreeNode root, Integer lowerLimit, Integer upperLimit){
        if(root == null) return true;
        if(lowerLimit != null && root.val < lowerLimit) return false;
        if(upperLimit != null && root.val > upperLimit) return false;
        //no need think too much, only 1 value will be passed into isBST once, never 2 passed into it at the same time
        //Because we only have 1 root
        return isBST(root.left,lowerLimit,root.val) && isBST(root.right, root.val, upperLimit);
    }
    
    public int countNode(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else return countNode(root.left)+countNode(root.right)+1;
    }
}