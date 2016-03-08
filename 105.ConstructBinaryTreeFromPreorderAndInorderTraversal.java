105. Construct Binary Tree from Preorder and Inorder Traversal My Submissions Question
Total Accepted: 57953 Total Submissions: 205998 Difficulty: Medium
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

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
//Got inspired by this Indian video, which uses test cases as follow
//https://www.youtube.com/watch?v=PAYG5WEC1Gs
//https://leetcode.com/discuss/12179/my-accepted-java-solution
//Inorder: [15,30,35,40,45,50,60,70,72,75,77,80]
//Preorder: [50,30,15,40,35,45,70,60,80,75,72,77]
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return construct(0,0,inorder.length-1,preorder,inorder);
    }
    
    public TreeNode construct(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length - 1 || inStart > inEnd ) return null;
        int inRoot = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(preorder[preStart] == inorder[i]) {
                inRoot = i;
                break;
            }
        }
        int inLength = inRoot - inStart + 1; 
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = construct(preStart+1, inStart, inRoot-1, preorder, inorder);
        root.right = construct(preStart + inLength, inRoot + 1, inEnd, preorder, inorder);
        return root;
    }
}
