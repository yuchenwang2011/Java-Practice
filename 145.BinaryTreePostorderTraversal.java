145. Binary Tree Postorder Traversal My Submissions Question
Total Accepted: 89851 Total Submissions: 258630 Difficulty: Hard
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

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
//Postorder Traversal [1,2,3,4,5,6,7] --> [4,5,2,6,7,3,1]
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        process(root,result);
        return result;
    }
    
    public void process(TreeNode root, List<Integer> result){
        if(root == null) return;
        if(root.left != null) process(root.left,result);
        if(root.right != null) process(root.right,result);
        result.add(root.val);
    }
}

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(0,current.val);
            if(current.left != null) stack.push(current.left);
            if(current.right != null) stack.push(current.right);
        }
        return result;
    }
}
