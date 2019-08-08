272. Closest Binary Search Tree Value II
Hard

Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

Example:
Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]

Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

Hint:
1. Consider implement these two helper functions:
getPredecessor(N), which returns the next smaller node to N.
getSuccessor(N), which returns the next larger node to N.
2. Try to assume that each node has a parent pointer, it makes the problem much easier.
3. Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
4. You would need two stacks to track the path in finding predecessor and successor node separately.

Answer:
//一看到bst就想到inorder，因为这样能利用从小到大遍历
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null || k <= 0) return result;
        helper(root, target, k, result);
        return result;
    } 
    
    public void helper(TreeNode root, double target, int k, LinkedList<Integer> result){
        if(root == null) return;
        helper(root.left, target, k, result);
        
        if(result.size() == k){
            if(Math.abs(root.val - target) < Math.abs(result.peek() - target)) {
                result.poll();
            } else return; //注意这里，如果没有更小的而且存满了，说明后面的也没戏了，就不继续了
        }
        result.add(root.val);
        
        helper(root.right, target, k, result);
    }
}
