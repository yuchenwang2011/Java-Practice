314. Binary Tree Vertical Order Traversal My Submissions QuestionEditorial Solution
Total Accepted: 4225 Total Submissions: 14008 Difficulty: Medium
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
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
public class Solution {
    //Got inpired by this answer:
    //https://leetcode.com/discuss/75054/5ms-java-clean-solution
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> cols = new LinkedList<Integer>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        queue.add(root);
        cols.add(0);
        int min = 0, max = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = cols.poll();
            if(!map.containsKey(col)) map.put(col, new ArrayList<Integer>());
            map.get(col).add(node.val);
            
            if(node.left != null){
                queue.add(node.left);
                cols.add(col-1);
                if(col <= min) min = col - 1;
            }
            
            if(node.right != null) {
                queue.add(node.right);
                cols.add(col+1);
                if(col >= max) max = col + 1;
            }
        }
        
        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }
        return result;
    }
}
