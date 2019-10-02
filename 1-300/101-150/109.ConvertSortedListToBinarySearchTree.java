109. Convert Sorted List to Binary Search Tree   My Submissions QuestionEditorial Solution
Total Accepted: 68950 Total Submissions: 226684 Difficulty: Medium
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/discuss/35476/Share-my-JAVA-solution-1ms-very-short-and-concise.
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }
    
    public TreeNode helper(ListNode head, ListNode tail){
        //that means, tail will never be used to build tree
        //so that already used slow.val won't be reused
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }
}

//my own solution oct 1, 2019
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head);
    }
    
    public TreeNode helper(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        ListNode next = slow.next;
        slow.next = null;
        root.right = helper(next);
        
        pre.next = null;
        root.left = helper(head);   
        return root;
    }
}
