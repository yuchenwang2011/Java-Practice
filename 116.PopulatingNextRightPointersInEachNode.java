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
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Node rootBackUp = root;
        Node secondLevel = root.left;
        while(root != null && secondLevel != null){
            if(root.left != null) root.left.next = root.right;
            Node lastRight = root.right;
            if(root.next != null) {
                root = root.next;
                lastRight.next = root.left;
            } else {
                root = secondLevel;
                secondLevel = root.left;
            }
        }
        return rootBackUp;
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

//May25 2019, the method signature has changed, below are my own 3 solutions
class Solution {
    public Node connect(Node root) {
        helper(root, null);
        return root;
    }
    
    public void helper(Node first, Node second){
        if(first == null) return;
        first.next = second;
        
        helper(first.left, first.right);
        if(second != null) helper(first.right, second.left);
        if(second != null) helper(second.left, second.right);
    }    
}

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Node node = queue.poll();
                size--;
                if(size > 0) node.next = queue.peek();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }
}
