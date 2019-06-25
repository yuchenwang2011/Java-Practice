143. Reorder List My Submissions Question
Total Accepted: 58996 Total Submissions: 265283 Difficulty: Medium
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

Answer:
//First Answer is my idea
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode first = head, second = head.next.next;
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        first = first.next;
        ListNode secondHead = first.next;
        first.next = null;
        
        secondHead = reverseList(secondHead);
        ListNode firstHead = head;
       
        while(secondHead != null) {
            ListNode firstNext = firstHead.next;
            ListNode secondNext = secondHead.next;
            secondHead.next = firstHead.next;
            firstHead.next = secondHead;
            firstHead  = firstNext;
            secondHead = secondNext;
        }
        
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = null, current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

//my own solution June 3 2019
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2, null);
        ListNode newHead = merge(head, head2);
    }
    
    public ListNode reverse(ListNode head, ListNode prev){
        if(head == null) return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverse(next, head);
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        ListNode headBackup = head1;
        while(head1 != null && head2 != null){
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            
            head1 = next1;
            head2 = next2;
        }
        return headBackup;
    }
}

