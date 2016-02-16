104. Maximum Depth of Binary Tree My Submissions Question
Total Accepted: 121607 Total Submissions: 257901 Difficulty: Easy
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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
//First one is my own answer:
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return findDepth(root,0);
    }
    
    public int findDepth(TreeNode root, int depth){
        if(root == null) return depth;
        depth++;
        //at first I made a mistake, i can't pass depth++ into the recursion, because it adds 1 twice
        int depthLeft = findDepth(root.left,depth);
        int depthRight = findDepth(root.right,depth);
        return Math.max(depthLeft,depthRight);
    }
}

//This answer is from other people
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
