116. Populating Next Right Pointers in Each Node My Submissions Question
Total Accepted: 81625 Total Submissions: 223958 Difficulty: Medium
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

Answer:
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//The answer below is more decent
//https://leetcode.com/discuss/7327/a-simple-accepted-solution
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            root.next = null;
            return;
        }
        TreeLinkNode current = root, secondLevel = root.left;
        while(current != null && secondLevel != null) {
            current.left.next = current.right;
            TreeLinkNode tmpRight = current.right;
            current = current.next;
            if(current == null){
                tmpRight.next = null;
                current = secondLevel;
                secondLevel = secondLevel.left;
            } else {
                tmpRight.next = current.left;
            }
        }
    }
}

//Though Recursion is not constant space, I think this solution is very decent
//https://leetcode.com/discuss/32318/my-recursive-solution-java
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
