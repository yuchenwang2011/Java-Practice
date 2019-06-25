98. Validate Binary Search Tree My Submissions Question
Total Accepted: 84265 Total Submissions: 405765 Difficulty: Medium
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
//Test case [1,1], [3,null,30,10,null,null,15,null,45],[2147483644,-2147483648,2147483646,null,null,2147483645,2147483647]
//Got Inspired by this answer
//https://leetcode.com/discuss/68979/java-solution-time-space-using-integer-object-null-pointer
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return process(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean process(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return process(root.left, min, root.val) && process(root.right, root.val, max);
    }
}

//Got inspired by this answer
//https://leetcode.com/discuss/22234/my-java-inorder-iteration-solution
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        //you can also use TreeNode pre = null; instead
        long tmp = Long.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while(root != null || !stack.isEmpty() ){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                TreeNode current = stack.pop();
                if(current.val <= tmp) return false;
                //Since Inoder tranversal of BST is in sorted order, we need not check the other case of right side .
                tmp = current.val;//as the values should be larger and larger
                root = current.right;
            }
        }
        return true;
    }
}
