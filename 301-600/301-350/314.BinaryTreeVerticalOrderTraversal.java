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
class Solution {
    //https://leetcode.com/problems/binary-tree-vertical-order-traversal/solutions/76401/5ms-java-clean-solution/
    //https://github.com/yuchenwang2011/Java-Practice/blob/master/301-600/301-350/314.jpg
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Queue<Integer> cols = new LinkedList<>();
        cols.offer(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int min = 0;
        int max = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                int col = cols.poll();
                if(!map.containsKey(col)) map.put(col, new ArrayList<>());
                map.get(col).add(node.val);
                
                if(node.left != null) {
                    queue.offer(node.left);
                    cols.offer(col - 1);
                    if(col - 1 < min) min--; 
                }
                if(node.right != null) {
                    queue.offer(node.right);
                    cols.offer(col + 1);
                    if(col + 1 > max) max++;
                }
            }
        }
        
        for(int i = min; i <= max; i++){
            result.add(map.get(i));
        }     
        return result;
    }
}
