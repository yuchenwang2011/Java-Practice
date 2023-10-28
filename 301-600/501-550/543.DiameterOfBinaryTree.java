543. Diameter of Binary Tree
Easy 12.6K 805

Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
Accepted 1.2M Submissions 2.1M Acceptance Rate 58.2%

Answer:
 //from this answer:
 //https://leetcode.com/problems/diameter-of-binary-tree/solutions/101132/java-solution-maxdepth/
class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        getHeight(root);
        return max;
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        max = Math.max(max, leftHeight + rightHeight); //note, here doesn't add 1, it says between, consider as no root
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
