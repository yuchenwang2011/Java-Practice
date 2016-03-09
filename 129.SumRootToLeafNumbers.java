129. Sum Root to Leaf Numbers My Submissions Question
Total Accepted: 70991 Total Submissions: 220605 Difficulty: Medium
Given a binary tree containing digits from 0-9 only, 
each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

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
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return 0;
        int value = 0;
        dfs(root, result, value);
        for(int i = 0; i < result.size(); i++) {
            value = value + result.get(i);
        }
        return value;
    }
    
    public void dfs(TreeNode root, List<Integer> result, int value){
        value = value*10 + root.val;
        if(root.left == null && root.right == null) {
            result.add(value);
            return;
        }
        if(root.left != null) dfs(root.left, result, value);
        if(root.right != null) dfs(root.right, result, value);
    }
}

//This answer is better than mine
//https://leetcode.com/discuss/20451/short-java-solution-recursion
