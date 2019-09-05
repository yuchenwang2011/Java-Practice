25. Reverse Nodes in k-Group 
Hard
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
Example:
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
Note:
Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

Solution:
//this is my own solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        int length = 0;
        ListNode iterator = head;
        while(iterator != null){
            iterator = iterator.next;
            length++;
        }
        return reverseHelper(length, head, k);
    }
    
    public ListNode reverseHelper(int length, ListNode head, int k){
        if(k > length) return head;
        
        ListNode tail = head;
        int i = 0;
        while(i < k - 1){
            tail = tail.next;
            i++;
        }
        ListNode newHead = tail.next;
        tail.next = null;
        
        ListNode result = reverseListNodes(head);
        head.next = reverseHelper(length - k, newHead, k);
        return result;
    }
    
    public ListNode reverseListNodes(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
    
            prev = current;
            current = next;            
        }
        return prev;
    }
}
