285. Inorder Successor in BST My Submissions Question
Total Accepted: 6290 Total Submissions: 17942 Difficulty: Medium
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Answer:
//这题必须掌握下面三种解法, iterative, recursive + Predecessor
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return root;
        TreeNode result = null;
        
        while(root != null){
            if(root.val <= p.val) root = root.right;
            else {
                result = root;
                root = root.left;
            }
        }
        
        return result;
    }
}

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        if(root.val > p.val) {
            TreeNode leftResult = inorderSuccessor(root.left,p);
            return leftResult == null? root: leftResult;
        } 
        return inorderSuccessor(root.right,p);
    }
}
