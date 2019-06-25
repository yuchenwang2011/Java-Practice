111. Minimum Depth of Binary Tree My Submissions Question
Total Accepted: 93683 Total Submissions: 310235 Difficulty: Easy
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
//Same idea as mine but a little better
//https://leetcode.com/discuss/76318/very-easy-with-recursion-1ms-java-solution
//There's another BFS solution very interesting, the first reply
//https://leetcode.com/discuss/6308/my-solution-used-level-order-traversal
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else if (root.left != null && root.right == null) return minDepth(root.left)+1; 
        else if (root.right != null && root.left == null) return minDepth(root.right)+1;
        else return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}


//actually above solution can be simplified to this, but above it is easier to understand
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right == null) return minDepth(root.left) + 1;
        if(root.left == null && root.right != null) return minDepth(root.right) + 1;
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}


class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) return depth;
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
