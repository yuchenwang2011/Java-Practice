156. Binary Tree Upside Down My Submissions Question
Total Accepted: 8825 Total Submissions: 23547 Difficulty: Medium
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  

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
//Got inspired by this answer: very hard to understand, you just need to go with the while loop one step by one step
//https://leetcode.com/discuss/18410/easy-o-n-iteration-solution-java
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        TreeNode current = root;
        TreeNode nextRoot = null;
        TreeNode prevRoot = null;
        TreeNode rightToLeft = null;
        
        while(current != null){
            //save current.left first to another node
            nextRoot = current.left;
            current.left = rightToLeft;
            //save current.right first to another node
            rightToLeft = current.right;
            current.right = prevRoot;
            prevRoot = current;
            current = nextRoot;
        }
        return prevRoot;
    }
}

//Got inspired by this answer: it's hard to understand, you need to go through it on the paper
//https://leetcode.com/discuss/44718/clean-java-solution
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null) ) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
