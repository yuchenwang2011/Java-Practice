100. Same Tree My Submissions Question
Total Accepted: 110196 Total Submissions: 258032 Difficulty: Easy
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //it should be as long as 1 false is returned, the whole recursion should return a false
        if(p == null || q == null) return (p == null && q == null);
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}


//this is my iterative solution May 24 2019, actually i don't think it is necessary
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(p);
        stack.push(q);

        while(!stack.isEmpty()){
            int size = stack.size();
            while(size >= 2){
                TreeNode first = stack.pop();
                TreeNode second = stack.pop();
                size -= 2;
                if(first.val != second.val) return false;
                
                if(first.left != null && second.left == null 
                  || first.left == null && second.left != null) {
                    return false;
                } else if (first.left != null && second.left != null){
                    stack.push(first.left);
                    stack.push(second.left);
                }
                
                if(first.right != null && second.right == null
                  || first.right == null && second.right != null) {
                    return false;
                } else if(first.right != null && second.right != null){
                    stack.push(first.right);
                    stack.push(second.right);
                }
            }
        }
        
        return true;
    }
}
