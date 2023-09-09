1161. Maximum Level Sum of a Binary Tree
Medium

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

Example 1:
Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
 
Note:
The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5
Accepted 2,669 Submissions 3,682

Answer:
//这个是我在contest 150里自己的回答
class Solution {
    public int maxLevelSum(TreeNode root) {
        int result = 1;
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(sum >= count) {
                count = sum;
                result = level;
            }
            level++;
        }
        return result;
    }
}

//inspired from this answer
//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/solutions/360968/java-python-3-two-codes-language-bfs-level-traversal-and-dfs-level-sum
class Solution {
    public int maxLevelSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        
        int maxLevel = 0;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(maxLevel) < list.get(i)) {
                maxLevel = i;
            }
        }
        return maxLevel + 1;
    }
    private void dfs(TreeNode n, List<Integer> l, int level) {
        if (n == null) { return; } 
        if (l.size() == level) { l.add(n.val); } // never reach this level before, add first value.
        else { l.set(level, l.get(level) + n.val); } // reached the level before, accumulate current value to old value.
        dfs(n.left, l, level + 1);
        dfs(n.right, l, level + 1);
    }
}
