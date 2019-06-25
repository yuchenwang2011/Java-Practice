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
public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode closeNode = root;
        while(root != null){
          if(Math.abs(target-(double) root.val) < Math.abs(target-(double) closeNode.val)){
              closeNode = root;
          }
          if(target >= (double)root.val){
              root = root.right;
          } else {
              root = root.left;
          }
        }
        return closeNode.val;
    }
}
