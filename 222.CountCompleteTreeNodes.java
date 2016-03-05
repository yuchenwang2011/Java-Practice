222. Count Complete Tree Nodes My Submissions Question
Total Accepted: 28215 Total Submissions: 115875 Difficulty: Medium
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, 
is completely filled, and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.

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
//Got inspired by this answer, but note his getHeight method is stupid and misleading
//https://leetcode.com/discuss/38930/concise-java-solutions-o-log-n-2
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height = getHeight(root);
        int rightHeight = getHeight(root.right);
        if(height == 0) return 0;
        else {
            if(height == rightHeight+1){//it means the last node falls in the subtree of the right node
                return (1 << (height-1)) -1 + 1 + countNodes(root.right); //1<<height equals 2^(h-1), left + root + right
            } else {
                return (1 << (height-2)) -1 + 1 + countNodes(root.left);
            }
        }
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + getHeight(root.left);
    }
}

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int count = 0;
        while(root!= null){
            int height = getHeight(root);
            if(height == getHeight(root.right) + 1 ) {
                count = count + (1 << (height-1)) ;
                root = root.right;
            } else {
                count = count + (1 << (height-2)) ;
                root = root.left;
            }
        }
        return count;
     }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + getHeight(root.left);
    }
}

public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int height =0;
        TreeNode left = root, right = root;
        while(right != null){
            left = left.left;
            right = right.right;
            height++;
        }
        if(left == null) return 1 << height - 1; //means this is a full tree
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
