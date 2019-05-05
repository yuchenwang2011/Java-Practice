102. Binary Tree Level Order Traversal My Submissions Question
Total Accepted: 89473 Total Submissions: 282151 Difficulty: Easy
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
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
//Got inspired by these 2 answers: only 1 BFS solution, can be implemented by iterative and recursive
//https://dowshawu.gitbooks.io/technical-interview-tutorial/content/binary_tree_&_divide_and_conquer/binary_tree_level_order_traversal.html
//http://ryanleetcode.blogspot.ca/2015/04/binary-tree-level-order-traversal-bfs.html
public class Solution {
    //as long as you know queue is FIFO, you will understand
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if(root == null) return result;
      //interface queue is implemented by linkedlist
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      while(queue.isEmpty() != true){
          List<Integer> tmp = new ArrayList<Integer>();
          int size = queue.size();
          for(int i = 0; i < size; i++) {
              TreeNode current = queue.poll();
              if(current.left != null) queue.offer(current.left);
              if(current.right != null) queue.offer(current.right);
              tmp.add(current.val);
          }
          result.add(tmp);
      }
      return result;
    }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if(root == null) return result;
      Queue<TreeNode> queue = new LinkedList<TreeNode>();
      queue.offer(root);
      process(result, queue);
      return result;
    }

    //***********Remember!!!after Queue, you need give the <TreeNode>!!!!!    
    public void process(List<List<Integer>> result,Queue<TreeNode> queue){
        if(queue.isEmpty()) return;
         List<Integer> tmp = new ArrayList<Integer>();
          int size = queue.size();
        for(int i = 0; i < size; i++) {
              TreeNode current = queue.poll();
              if(current.left != null) queue.offer(current.left);
              if(current.right != null) queue.offer(current.right);
              tmp.add(current.val);
        }
        result.add(new ArrayList<Integer>(tmp));
        process(result, queue);
    }
}


//May5,2019 my own recursive solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        helper(root, result, 0);
        return result;
    }
    
    public void helper(TreeNode root, List<List<Integer>> result, int level){
        if(root == null){
            return;
        }
        if(result.size() <= level) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
        } else {
            result.get(level).add(root.val);
        }
        
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
