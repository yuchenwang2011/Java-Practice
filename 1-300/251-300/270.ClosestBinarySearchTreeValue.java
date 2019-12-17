270. Closest Binary Search Tree Value My Submissions Question
Total Accepted: 8561 Total Submissions: 25863 Difficulty: Easy
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.

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
//掌握两种做法
class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        int result = root.val;
        while(root != null){
            if(Math.abs(target - root.val) < Math.abs(target - result)) result = root.val;
            root = target > root.val ? root.right : root.left;
        }
        return result;
    }
}

class Solution {
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }
    
    public int helper(TreeNode root, double target, int result){
        if(root == null) return result;
        if(Math.abs(root.val - target) < Math.abs(result - target)) result = root.val;
        root = target > root.val ? root.right : root.left;
        return helper(root, target, result);
    }
}


//我自己的解法
class Solution {
    int min;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        min = root.val;
        helper(root, target, Math.abs(root.val - target));
        return min;
    }
    
    public void helper(TreeNode root, double target, double diff){
        if(root == null) return;
        double currentDiff = Math.abs(root.val - target);
        if(currentDiff < diff) min = root.val;
        if(root.val < target) {
            helper(root.right, target, Math.min(currentDiff, diff));            
        } else {
            helper(root.left, target, Math.min(currentDiff, diff));
        }
    }
}
