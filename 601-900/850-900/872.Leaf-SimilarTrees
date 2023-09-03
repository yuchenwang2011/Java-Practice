872. Leaf-Similar Trees
Easy 3.2K 71

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
Two binary trees are considered leaf-similar if their leaf value sequence is the same.
Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Example 2:
Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
 
Constraints:
The number of nodes in each tree will be in the range [1, 200].
Both of the given trees will have values in the range [0, 200].

Accepted 284.5K Submissions 419.5K Acceptance Rate 67.8%

Answer:
//本来我用的是两个list存下来然后比较两个list，但是这个算法更妙
//https://leetcode.com/problems/leaf-similar-trees/solutions/152358/simple-6-lines-java-stringbuilder-traverse-with-explanation
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return findLeafs(root1).equals(findLeafs(root2));
    }

    public String findLeafs(TreeNode root){
        if(root == null) return "";
        if(root.left == null && root.right == null) return root.val + "-";
        return findLeafs(root.left) + findLeafs(root.right);
    }
}
