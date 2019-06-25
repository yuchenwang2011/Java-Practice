113. Path Sum II My Submissions Question
Total Accepted: 72402 Total Submissions: 260767 Difficulty: Medium
Given a binary tree and a sum, find all root-to-leaf paths where each path's 
sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

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
//I used DFS and got accepted, but not as decent as this one
//https://leetcode.com/discuss/43457/another-accepted-java-solution
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        List<Integer> tmp = new ArrayList<Integer>();
        process(root,result,tmp,sum);
        return result;
    }
    public void process(TreeNode root, List<List<Integer>> result, List<Integer> tmp, int sum){
        if(root == null) return;
        tmp.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            result.add(new ArrayList<Integer>(tmp));
        } else {
            process(root.left,result,tmp,sum-root.val);
            process(root.right,result,tmp,sum-root.val);
        }
        tmp.remove(tmp.size()-1);
    }
}
