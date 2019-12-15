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
//我自己的解法，最好的
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int level = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;

        while(left != null && right != null){
            left = left.left;
            right = right.right;
            level++;
        }
        if(left == null && right == null) return (1 << level) - 1;
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
}

//来自我自己的跟上面类似的解法
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        TreeNode rootBackup = root;
        
        int levelLeft = 0;
        while(root != null){
            root = root.left;
            levelLeft++;
        }
        
        int levelRight = 0;
        root = rootBackup;
        while(root != null){
            root = root.right;
            levelRight++;
        }
        
        if(levelLeft == levelRight) return (int) Math.pow(2, levelLeft) - 1;
        return 1 + countNodes(rootBackup.left) + countNodes(rootBackup.right);
    }
}


class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int hLeft = getHeight(root.left);
        int hRight = getHeight(root.right);
        if(hLeft == hRight) return 1 + (1 << hLeft) - 1 + countNodes(root.right);
        return 1 + countNodes(root.left) + (1 << hRight) - 1;
    }
    
    public int getHeight(TreeNode root){
        int h = 0;
        if(root == null) return 0;
        while(root != null){
            root = root.left;
            h++;
        }
        return h;
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        int result = 0;
        if(root == null) return result;
        while(root != null){
            int hLeft = getHeight(root.left);
            int hRight = getHeight(root.right);
            if(hLeft == hRight) {
                result += 1 + (1 << hLeft) - 1;
                root = root.right;
            } else {
                result += 1 + (1 << hRight) - 1;
                root = root.left;
            }            
        }
        return result;
    }
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + getHeight(root.left);
    }
}
