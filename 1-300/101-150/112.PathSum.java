112. Path Sum My Submissions Question
Total Accepted: 90648 Total Submissions: 294133 Difficulty: Easy
Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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
//Be careful, it says root-to-leaf path
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return root.val == sum;
        else return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}


class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.left == null && root.right == null && root.val == sum) return true;
            
            if(root.left != null) {
                root.left.val += root.val;
                queue.offer(root.left);
            }
            if(root.right != null) {
                root.right.val += root.val;
                queue.offer(root.right);
            }
        }
        return false;
    }
}
