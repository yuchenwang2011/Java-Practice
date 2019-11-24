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
        if(head == null || head.next == null || k == 1) return head;
        
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        int i = 0;
        ListNode begin = newHead;
        while(head != null){
            i++;
            if(i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return newHead.next;
    }
    
    //-1->1->2->3->4 变成 -1->3->2->1->4, return 1
    public ListNode reverse(ListNode start, ListNode end){
        ListNode backupStart = start;
        ListNode result = start.next;
        
        ListNode iter = start.next;
        while(iter != end){
            ListNode next = iter.next;
            iter.next = start;
        
            start = iter;
            iter = next;
        }
        backupStart.next = start;
        result.next = end;
        return result;
    }
}


First, build a function reverse() to reverse the ListNode between begin and end. See the explanation below:

   /**
     * Reverse a link list between begin and end exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |   
     * begin       end
     * after call begin = reverse(begin, end)
     * 
     * 0->3->2->1->4->5->6
     *          |  |
     *      begin end
     * @return the reversed list's 'begin' node, which is the precedence of node end
     */
Then walk thru the linked list and apply reverse() iteratively. See the code below.
