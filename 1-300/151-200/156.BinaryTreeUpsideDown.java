156. Binary Tree Upside Down My Submissions Question
Total Accepted: 8825 Total Submissions: 23547 Difficulty: Medium
Given a binary tree where all the right nodes are either leaf nodes 
with a sibling (a left node that shares the same parent node) or empty, 
flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
    Return the new root.

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
//Got inspired by this answer: it's hard to understand, see picture below
//https://github.com/yuchenwang2011/Java-Practice/blob/master/156.BinaryTreeUpsideDown.png
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
