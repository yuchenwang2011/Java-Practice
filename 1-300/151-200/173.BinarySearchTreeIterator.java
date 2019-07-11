173. Binary Search Tree Iterator My Submissions Question
Total Accepted: 41014 Total Submissions: 122989 Difficulty: Medium
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Answer:
//same template as in question 144
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    TreeNode root;
    private Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        //remember to use this
        this.root = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        //the question said it will always be valid
        TreeNode node = stack.pop();
        root = node.right;
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(root != null || !stack.isEmpty()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
