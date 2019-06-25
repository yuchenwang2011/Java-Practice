99. Recover Binary Search Tree
Hard

Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.

Example 1:
Input: [1,3,null,null,2]
   1
  /
 3
  \
   2
Output: [3,1,null,null,2]
   3
  /
 1
  \
   2
   
Example 2:
Input: [3,1,4,null,null,2]
  3
 / \
1   4
   /
  2
Output: [2,1,4,null,null,3]
  2
 / \
1   4
   /
  3
  
Follow up:
A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?

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
class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                
                if(prev != null && root.val <= prev.val) {
                    if(first == null) first = prev;
                    //alert: it could be this weirld <= case just happens once
                    //so prev and current root are first and second
                    //it could also be temporarily, so second will be updated later
                    second = root;
                }
                prev = root;
                root = root.right;
            }
        }
        
        if(first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}


class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        helper(root);
        if(first != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
    
    public void helper(TreeNode root){
        if(root == null) return;
        helper(root.left);
        if(prev != null && prev.val >= root.val) {
            if(first == null) first = prev;
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}
