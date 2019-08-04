257. Binary Tree Paths My Submissions Question
Total Accepted: 35253 Total Submissions: 130379 Difficulty: Easy
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Answer:
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        helper(result, "", root);
        return result;
    }
    
    public void helper(List<String> result, String tmp, TreeNode root){
        if(root.left == null && root.right == null) {
            result.add(tmp + root.val);
            return;   
        }    
        if(root.left != null)  helper(result, tmp + root.val + "->", root.left);
        if(root.right != null) helper(result, tmp + root.val + "->", root.right);
    }
}
