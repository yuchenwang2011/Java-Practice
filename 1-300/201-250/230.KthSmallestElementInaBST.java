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
//这个题里的count就不是第几个了，而是一共有多少个node，跟前面两个解法的代表意义不同了
//First time it needs O(N) to rebuild the tree, but after that it will be binary search and O(logN)
class Solution {
    class TreeNode2{
        int val;
        int count;
        TreeNode2 left;
        TreeNode2 right;
        TreeNode2(int x){
            val = x;
            count = 1;
        }
    }
    
    public TreeNode2 updateTree(TreeNode root){
        //注意下行必须return null，如果return root，type不对
        if(root == null) return null;
        TreeNode2 root2 = new TreeNode2(root.val);
        if(root.left != null) {
            root2.left = updateTree(root.left);
            root2.count += root2.left.count;
        }
        if(root.right != null) {
            root2.right = updateTree(root.right);
            root2.count += root2.right.count;
        }
        return root2;
    }
    
    private int result = Integer.MAX_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0) return result;
        TreeNode2 root2 = updateTree(root);
        helper(root2, k);
        return result;
    }
    
    public void helper(TreeNode2 root, int k){
        if(root == null || k <= 0) return;
        if(root.left != null) {
            if(root.left.count + 1 == k) {
                result = root.val;
                return;
            } else if (root.left.count >= k){
                helper(root.left, k);
            } else {
                helper(root.right, k - 1 - root.left.count);
            }
        } else {
            if(k == 1) {
                result = root.val;
                return;
            } else {
                helper(root.right, k - 1);
            }
        }
    }
}
