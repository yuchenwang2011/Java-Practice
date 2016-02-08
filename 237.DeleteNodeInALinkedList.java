237. Delete Node in a Linked List My Submissions Question
Total Accepted: 60761 Total Submissions: 138891 Difficulty: Easy
Write a function to delete a node (except the tail) in a singly linked list, 
given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
the linked list should become 1 -> 2 -> 4 after calling your function.

Answer:
//This question is a brain teeser.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        
        node.val = node.next.val;
        node.next = node.next.next;
        //Don't need to make a new node = node.next, newNode.next = null, because node.next will be GC.
    }
}
