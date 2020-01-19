333. Largest BST Subtree My Submissions Question
Total Accepted: 1342 Total Submissions: 5130 Difficulty: Medium
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.
Hint:

You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?

Answer:
class Solution {
    class Node{
        int size;
        int lower;
        int upper;
        public Node(int size, int lower, int upper){
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    int result;
    
    public int largestBSTSubtree(TreeNode root) {
        result = 0;
        if(root == null) return result;
        helper(root);
        return result;
    }
    
    public Node helper(TreeNode root){
        if(root == null) {
            return new Node(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Node left = helper(root.left);
        Node right = helper(root.right);
        if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            //right的lower，就是右边所有点的最小值，root肯定必须比右边最小值小才行
            //left的upper,就是左边所有点的最大值，root肯定必须比左边最大值大才行
            return new Node(-1, 0, 0);
        }
        int size = left.size + right.size + 1;
        result = Math.max(result, size);
        return new Node(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
