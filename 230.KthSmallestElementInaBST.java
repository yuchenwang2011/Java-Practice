230. Kth Smallest Element in a BST My Submissions Question
Total Accepted: 37549 Total Submissions: 103568 Difficulty: Medium
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

1.Try to utilize the property of a BST.
2.What if you could modify the BST node's structure?
3.The optimal runtime complexity is O(height of BST).

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
//This is my own idea, it definitly has some issues to work out.
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        while(k >= 1){
          int leftCount = countNode(root.left);
          int rightCount = countNode(root.right);
          if(k == leftCount+1) return root.val;
          else if (k <= leftCount) root = root.left;
          else {
              root = root.right;
              k = k - leftCount -1;
          }
        }
        return root.val;
    }
    
    public int countNode(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return countNode(root.left) + countNode(root.right) +1; 
    }
}

//This solution will use in-order traversal recursion.
//https://leetcode.com/discuss/68052/two-easiest-in-order-traverse-java
public class Solution {
    int count = 0;
    int result = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root,k);
        return result;
    }
    
    public void inorderTraversal(TreeNode root, int k){
        if(root == null) return;
        if(root.left != null) inorderTraversal(root.left,k);
        if(++count == k) {result = root.val; return;}
        if(root.right != null) inorderTraversal(root.right,k);
    }
}

//This solution will use in-order traversal iterative
//https://leetcode.com/discuss/68052/two-easiest-in-order-traverse-java
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        int result = Integer.MAX_VALUE;
        if(root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while(root != null || !stack.isEmpty() ){
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode current = stack.pop();
                if(++count == k) return current.val;
                root = current.right;
            }
        }
        return result;
    }
}
