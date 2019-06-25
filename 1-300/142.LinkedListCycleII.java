142. Linked List Cycle II My Submissions Question
Total Accepted: 66656 Total Submissions: 211769 Difficulty: Medium
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

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
    public ListNode detectCycle(ListNode head) {
        //this question still use fast runner and slow runner method
        //when fast catches slow, slow has gone A+B, where A is elements before cycle starts
        //B is some steps on the cycle, faster is twice as A, 2A+2B. 
        //Also let's define B+C = whole cycle
        //For fast: 2A+2B = A + B+ N(B+C)  --> A + B = N (B+C) --> A + B = (N-1)(B+C) + B+ C
        // --> A = (N-1)(B+C) + C, so A is 整圈儿 + slow剩下的部分。所以slow再走 A这么长就变成
        //了整圈儿，就能和head相遇了
        
        if(head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                while(head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }
}
