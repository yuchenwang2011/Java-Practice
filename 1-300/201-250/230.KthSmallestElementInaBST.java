230. Kth Smallest Element in a BST My Submissions Question
Total Accepted: 37549 Total Submissions: 103568 Difficulty: Medium
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
    How would you optimize the kthSmallest routine?

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
//这题需要掌握下面三种做法
//in-order traversal recursive.
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
        count++;
        if(count == k) {result = root.val; return;}
        if(root.right != null) inorderTraversal(root.right,k);
    }
}

//in-order traversal iterative
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
                count++;
                if(count == k) return current.val;
                root = current.right;
            }
        }
        return result;
    }
}

//This solution is what exactly Google is asking for -- to modify the TreeNode structure
//First time it needs O(N) to rebuild the tree, but after that it will be binary search and O(logN)
public class Solution {
    class TreeNode2 {
        int val;
        int count; //number of nodes of the tree
        TreeNode2 left;
        TreeNode2 right;
        TreeNode2 (int val) {
            this.val = val;
            count = 1;
        }
    }
    
    public TreeNode2 updateTreeNode(TreeNode root){ 
        if(root == null) return null;
        TreeNode2 root2 = new TreeNode2(root.val);
        if(root.left != null) root2.left = updateTreeNode(root.left);
        if(root.right != null) root2.right = updateTreeNode(root.right);
        if(root2.left != null) root2.count = root2.count + root2.left.count;
        if(root2.right != null) root2.count = root2.count + root2.right.count;
        return root2;
    }

    public int kthSmallest(TreeNode root, int k) {
        TreeNode2 root2 = updateTreeNode(root);
        return helper(root2,k);
    }
    
    public int helper(TreeNode2 root2, int k){
        if(k < 0 || root2 == null) return Integer.MAX_VALUE;
        if(root2.left != null) {
            if(root2.left.count+1 == k) return root2.val;
            if(root2.left.count >= k) return helper(root2.left,k);
            else return helper(root2.right,k - root2.left.count -1 );
        } else {
            if(k == 1) return root2.val;
            return helper(root2.right, k - 1);
        }
    }
}
