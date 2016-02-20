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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//The first answer is a very good DFS template, second answer is my first intention but i don't know StringBuilder class
//https://leetcode.com/discuss/79797/2ms-java-recursive-solution-with-explaination
//https://leetcode.com/discuss/55581/solution-using-stringbuilder-instead-string-manipulation
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        process(root,result,"");
        return result;
    }
    
    public void process(TreeNode root, List<String> result, String tmp){
        if(root == null) return;
        if(root.left == null && root.right == null){
            result.add(tmp + root.val);
            return; //only add to final result when the current node is a leaf
        }
        process(root.left, result, tmp + root.val + "->");
        process(root.right, result, tmp + root.val + "->");
    }
}

public class Solution {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> result = new ArrayList<String>();
        StringBuilder tmp = new StringBuilder();
        process(root,result,tmp);
        return result;
    }
    public void process(TreeNode root, List<String> result, StringBuilder tmp){
        if(root == null) return;
        int size = tmp.length();
        if(root.left == null && root.right == null) {
            tmp.append(root.val);
            result.add(tmp.toString());
            tmp.delete(size,tmp.length());
            return;
        }
        tmp.append(root.val + "->");
        process(root.left,result,tmp);
        process(root.right,result,tmp);
        tmp.delete(size,tmp.length());
    }
}
