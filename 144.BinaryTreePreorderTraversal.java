144. Binary Tree Preorder Traversal My Submissions Question
Total Accepted: 108687 Total Submissions: 279003 Difficulty: Medium
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

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
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        process(root,result);
        return result;
    }
    
    public void process(TreeNode root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        if(root.left != null) process(root.left,result);
        if(root.right != null) process(root.right,result);
    }
}