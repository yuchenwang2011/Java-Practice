141. Linked List Cycle My Submissions Question
Total Accepted: 92082 Total Submissions: 250220 Difficulty: Medium
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

Answer: 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Finally I understand why use faster and slower 2 pointers instead of just comparing 
        //faster and head. The cycle may not just start and end at head, but also a cycle like Q
        //say the cycle starts at the 3rd node
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){ //fast.next != null because fast goes 2 steps
           fast = fast.next.next;
           slow = slow.next;
           if(slow == fast){
               return true;
           }
        }
        return false;
    }
}
