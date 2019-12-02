86. Partition List My Submissions Question
Total Accepted: 58673 Total Submissions: 203634 Difficulty: Medium
Given a linked list and a value x, 
partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode prev1 = new ListNode(-1);
        ListNode prev2 = new ListNode(-1);
        
        ListNode h1 = prev1;
        ListNode h2 = prev2;
        while(head != null){
            if(head.val < x) {
                h1.next = head;
                h1 = h1.next;
            } else {
                h2.next = head;
                h2 = h2.next;
            }
            head = head.next;
        }
        h1.next = prev2.next;
        h2.next = null;
        return prev1.next;
    }
}
