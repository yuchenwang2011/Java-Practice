1372. Longest ZigZag Path in a Binary Tree
Medium 3.1K 60

You are given the root of a binary tree.
A ZigZag path for a binary tree is defined as follow:
Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
Return the longest ZigZag path contained in that tree.

Example 1:
Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

Example 2:
Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).

Example 3:
Input: root = [1]
Output: 0
 
Constraints:
The number of nodes in the tree is in the range [1, 5 * 104].
1 <= Node.val <= 100
Accepted 118K Submissions 176.8K Acceptance Rate 66.8%

Answer:
//followed this anwer: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/solutions/531867/java-python-dfs-solution
class Solution {
    public int longestZigZag(TreeNode root) {
        return dfs(root)[2];
    }

    public int[] dfs(TreeNode root){
        if(root == null) return new int[]{-1, -1, -1};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int result = Math.max(Math.max(left[1], right[0]) + 1, Math.max(left[2], right[2]));
        return new int[]{left[1] + 1, right[0] + 1, result};
    }
}
