19. Remove Nth Node From End of List My Submissions Question
Total Accepted: 92534 Total Submissions: 324528 Difficulty: Easy
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Better use test case [1,2,3,4,5] 2/5, and use 5 fingers to think
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return head;
        ListNode prevHead = new ListNode(-1);
        prevHead.next = head;
        
        ListNode iterator = head;
        
        int i = 0;
        while(i < n && iterator.next != null){
            iterator = iterator.next;
            i++;
        }
        if(i < n) return head.next;
        
        while(iterator.next != null){
            iterator = iterator.next;
            head = head.next;
        }
        head.next = head.next.next;
        return prevHead.next;
    }
}
