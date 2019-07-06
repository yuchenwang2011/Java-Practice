107. Binary Tree Level Order Traversal II My Submissions Question
Total Accepted: 70377 Total Submissions: 212602 Difficulty: Easy
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
    (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal,
 where '#' signifies a path terminator where no node exists below.

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
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if(root == null) return result;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      while(!queue.isEmpty()){
          List<Integer> tmp = new ArrayList<Integer>();
          int size = queue.size();
          for(int i = 0; i < size; i++) {
            TreeNode current = queue.poll();
            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
            tmp.add(current.val);
          }
          result.add(0,new ArrayList<Integer>(tmp));
      }
      return result;
    }
}


//May5, 2019 my own solution
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, result, 0);
        return result;
    }
    
    public void helper(TreeNode root, List<List<Integer>> result, int level){
        if(root == null) return;
        if(level >= result.size()) {
            result.add(0, new ArrayList<>());
        }
        result.get(result.size() - level - 1).add(root.val);
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
