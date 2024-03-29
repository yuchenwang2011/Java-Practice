82. Remove Duplicates from Sorted List II My Submissions Question
Total Accepted: 64492 Total Submissions: 245358 Difficulty: Medium
Given a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//First you need to understand question 83
//Then it's better to draw the stack diagram of [1,2,2,4,4]
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        if(head.next.val != head.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        while(head.next != null && head.val == head.next.val){
            head = head.next;
        }
        return deleteDuplicates(head.next);
    }
}

//Third round may16 2019, basically same as above answer
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        
        ListNode prev = newHead;
        while(head != null && head.next != null){
            if(head.val != head.next.val) {
                prev = head;
                head = head.next;
                continue;
            }
            while(head != null && head.next != null && head.val == head.next.val){
                head = head.next;
            }
            if(head != null) head = head.next;
            prev.next = head;
        }
        return newHead.next;
    }
}
