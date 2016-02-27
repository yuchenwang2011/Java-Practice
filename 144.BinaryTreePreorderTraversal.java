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
//Preorder Traveral is [1,2,3,4,5,6,7]--> [1,2,4,5,3,6,7]
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


//The one in the hello world is wrong, it should push the right node to stack first
//My test case is [1,2,3,4,5,6,7], you can manually count the stack and result to understand
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(current.val);
            if(current.right != null) stack.push(current.right);
            if(current.left != null) stack.push(current.left);
        }
        return result;
    }
}
