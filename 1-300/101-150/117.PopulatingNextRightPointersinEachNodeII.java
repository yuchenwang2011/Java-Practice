117. Populating Next Right Pointers in Each Node II
Medium

Given a binary tree
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

Example:
Picture on this link: 

Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}

Explanation: Given the above binary tree (Figure A), 
your function should populate each next pointer to point to its next right node, 
just like in Figure B.
 
Note:
You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.

Answer:
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Node backupRoot = root;
        
        while(root != null){
            Node prev = new Node(0);
            Node iter = prev;
            while(root != null){
                if(root.left != null) {
                    iter.next = root.left;
                    iter = iter.next;
                }
                if(root.right != null) {
                    iter.next = root.right;
                    iter = iter.next;
                }
                root = root.next;
            }
            root = prev.next;
        }
        return backupRoot;
    }
}


class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        helper(root);
        return root;
    }
    
    public void helper(Node root){
        if(root == null) return;
        Node prev = new Node();
        Node prevBackup = prev;
        while(root != null){
            if(root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if(root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }
            root = root.next;
        }
        helper(prevBackup.next);
    }
}
