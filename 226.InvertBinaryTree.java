226. Invert Binary Tree My Submissions Question
Total Accepted: 68863 Total Submissions: 157773 Difficulty: Easy
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), 
but you can’t invert a binary tree on a whiteboard so fuck off.

Answer:
tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//I solved by myself, and most people solve it the same way. but they are usually using 1 less line. You can refer to 
//https://leetcode.com/discuss/70704/java-1ms-recursive-solution
//https://leetcode.com/discuss/42059/my-simple-recursion-java-solution
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        //Below 3 lines can be put both before the recursion and after the recursion
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
