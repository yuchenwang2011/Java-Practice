24. Swap Nodes in Pairs My Submissions Question
Total Accepted: 81584 Total Submissions: 237477 Difficulty: Medium
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. 
You may not modify the values in the list, only nodes itself can be changed.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
      if(head == null || head.next == null) return head;
      ListNode newHead = new ListNode(-1);
      newHead.next = head;
      ListNode tmp = newHead;
      while(tmp.next != null && tmp.next.next != null){
          ListNode first = tmp.next;        
          ListNode second = tmp.next.next;  //[-1(tmp),1,2,3], [-1,1,2,3,4],[-1,1,2,3,4,5]
          first.next = second.next;         
          second.next = first;
          tmp.next = second;
          tmp = tmp.next.next;
      }
      return newHead.next;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}

//did it April 19, 2019, my own solution, I feel it's much easier to understand
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = first.next;
        
        first.next = second.next;
        second.next = first;
        first.next = swapPairs(first.next);
        return second;
    }
}

