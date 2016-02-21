95. Unique Binary Search Trees II My Submissions Question
Total Accepted: 49918 Total Submissions: 173398 Difficulty: Medium
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

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
//I got inspired by this answer
//https://leetcode.com/discuss/33003/java-recursive-solution-straight-forward
public class Solution {
    public List<TreeNode> generateTrees(int n){
        if(n==0) return new ArrayList<TreeNode>();
        return process(1,n);
    }
    
    public List<TreeNode> process(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end) {
            result.add(null);
            return result;
        }
        for(int rootValue = start; rootValue <= end; rootValue++){
            List<TreeNode> leftTrees = process(start, rootValue-1);
            List<TreeNode> rightTrees = process(rootValue+1,end);
            
            for(TreeNode leftRoot : leftTrees){
                for(TreeNode rightRoot : rightTrees){
                  TreeNode root = new TreeNode(rootValue);
                  root.left = leftRoot;
                  root.right = rightRoot;
                  result.add(root);
                }
            }
        }
        return result;
    }
}