94. Binary Tree Inorder Traversal My Submissions Question
Total Accepted: 111531 Total Submissions: 287280 Difficulty: Medium
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

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
//Inorder Traversal is [1,2,3,4,5,6,7] --> [4,2,5,1,6,3,7]
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        process(root,result);
        return result;
    }
    
    public void process(TreeNode root, List<Integer> result){
        if(root == null) return;
        if(root.left != null) process(root.left, result);
        result.add(root.val);
        if(root.right != null) process(root.right, result);
    }
    
}

//According to this answer, I can get an iterative template. It's a totally different idea
//https://leetcode.com/discuss/71943/preorder-inorder-and-postorder-iteratively-summarization
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while(root != null || !stack.isEmpty() ){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                TreeNode current = stack.pop();
                result.add(current.val);
                root = current.right;
            }
        }
        return result;
    }
}
