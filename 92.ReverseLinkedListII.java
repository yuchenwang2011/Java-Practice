92. Reverse Linked List II My Submissions Question
Total Accepted: 63733 Total Submissions: 233891 Difficulty: Medium
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Inspired by this answer:
//https://leetcode.com/discuss/25580/simple-java-solution-with-clear-explanation
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      if(head == null || head.next == null) return head;
      ListNode newHead = new ListNode(-1);
      newHead.next = head;
      ListNode prev = newHead;
      //to understand the range of i, think about [-1,1,2,3,4] m=2,m=4
      for(int i=0; i < m-1; i++) prev = prev.next;
      
      ListNode current = prev.next;
      ListNode next = current.next;
      
      //idea is: prev,2,3,4,5 --> prev,3,2,4,5 --> prev,4,3,2,5 --> prev,5,4,3,2
      //every time bring the next element of 2(current), to the front, prev's next
      for(int i = 0; i < (n-m); i++){ 
          current.next = next.next;
          next.next = prev.next;
          prev.next = next;
          next = current.next;
      }
      
      return newHead.next;
    }
}
