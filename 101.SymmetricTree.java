ymmetric Tree My Submissions Question
Total Accepted: 94713 Total Submissions: 284224 Difficulty: Easy
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

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
//Got Inspired by this answer
//https://leetcode.com/discuss/24972/concise-recursive-java-solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return process(root.left, root.right);
    }
    public boolean process(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return process(left.left, right.right) && process(left.right, right.left);
    }
}

//Got Inspired by this answer
//https://leetcode.com/discuss/41807/short-and-clean-java-iterative-solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        boolean result = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode current1 = queue.poll();
            TreeNode current2 = queue.poll();
            if(current1 == null && current2 == null) continue;
            else if (current1 == null || current2 == null) return false;
            else if (current1.val != current2.val) return false;
            else {
                queue.offer(current1.left);
                queue.offer(current2.right);
                queue.offer(current1.right);
                queue.offer(current2.left);
            }
        }
        return result;
    }
}
