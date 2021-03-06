285. Inorder Successor in BST My Submissions Question
Total Accepted: 6290 Total Submissions: 17942 Difficulty: Medium
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Answer:
//我自己的方法
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, p, null);
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode result){
        if(root == null) return result;
        if(root.val > p.val) {
            if(result == null || root.val < result.val) result = root;
            return helper(root.left, p, result);
        } else {
            return helper(root.right, p, result);
        }
    }
}


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

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return root;
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }
}

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return root;
        return helper(root, p, null);
    }
    
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode result){
        if(root == null || p == null) return result;
        if(root.val <= p.val) return helper(root.right, p, result);
        
        return helper(root.left, p, root);
    }
}

public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}
