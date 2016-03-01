285. Inorder Successor in BST My Submissions Question
Total Accepted: 6290 Total Submissions: 17942 Difficulty: Medium
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

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
//Attention this question is asking BST, so [5,3,7,2,4,6,8] --> [2,3,4,5,6,7,8]
//Got inspired by this answer:
//https://leetcode.com/discuss/77805/java-5ms-short-code-with-explanations
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while(root != null){
            if(root.val > p.val){ //means root can be a candidate, goes to left node for futher comparision
                 result = root;
                 root = root.left;
            } else {
                 root = root.right;   
            }
        }
        return result;
    }
}
