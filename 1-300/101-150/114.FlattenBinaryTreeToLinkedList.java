这题三个方法，反正怎么都记不住，干脆就硬记第一个解法
口诀是先撸到左，再撸到右，再左右左右
114. Flatten Binary Tree to Linked List My Submissions Question
Total Accepted: 76526 Total Submissions: 249527 Difficulty: Medium
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, 
each node's right child points to the next node of a pre-order traversal.

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
//Same as this answer, but this is O(N^2)
//https://leetcode.com/discuss/70059/easy-1ms-java-dfs-solution
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left; 
        root.left = null;
        while(root.right != null) root = root.right;
        root.right = tmp;
    }
}

//Got inspired by this answer, so hard to understand, write all the steps on paper
//This idea is opposite from mine, this is move the right branch to the left side
//相当于是只要是一个root有左右，就把右边的存起来，然后左边的找到最后一个点，把存起来的接到最右点的右边
//https://leetcode.com/discuss/30719/my-short-post-order-traversal-java-solution-for-share
public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        helper(root,null);
    }
    
    public TreeNode helper(TreeNode root, TreeNode prevRoot){
        if(root == null) return prevRoot;
        prevRoot = helper(root.right, prevRoot);
        prevRoot = helper(root.left, prevRoot);
        root.right = prevRoot;
        root.left = null;
        prevRoot = root;
        return prevRoot;
    }
}



//this is really smart, use example in question to manually go through it twice you will understand
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36991/Accepted-simple-Java-solution-iterative
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
            
            if(!stack.isEmpty()) node.right = stack.peek();
            node.left = null; //this is really important
        }
    }
}
