103. Binary Tree Zigzag Level Order Traversal My Submissions Question
Total Accepted: 54186 Total Submissions: 193827 Difficulty: Medium
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
//This question has 2 answer, both uses a flag, the other one is to use a stack to save, then pop stack at the end
//https://github.com/yuzhangcmu/LeetCode/blob/a10631c8bc6dbdc0be5a2a55431aeece34009720/algorithm/others/ZigzagLevelOrder.java
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                if(level % 2 ==1) {
                    tmp.add(current.val);
                } else {
                    tmp.add(0,current.val);
                }
            }
            result.add(tmp);
            level++;
        }
        return result;
    }
}


//May5th 2019, my own recursive solution
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        helper(root, result, 0);
        return result;
    }
    
    public void helper(TreeNode root, List<List<Integer>> result, int level){
        if(root == null) return;
        if(level >= result.size()){
            result.add(new ArrayList<Integer>());
        }
        if(level % 2 == 0) {
            result.get(level).add(root.val);   
        } else {
            result.get(level).add(0, root.val);
        }
        
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
