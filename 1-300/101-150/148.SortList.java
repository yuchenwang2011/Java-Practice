148. Sort List My Submissions Question
Total Accepted: 64007 Total Submissions: 265966 Difficulty: Medium
Sort a linked list in O(n log n) time using constant space complexity.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //From this question, I know that for linked list, when you need sorting, merge sort might be the only 
 //proper way. I got inspired by these 3 answers:
 //https://leetcode.com/discuss/1709/have-pretty-mergesort-method-anyone-speed-reduce-memory-usage
 //https://leetcode.com/discuss/44369/java-merge-sort-solution
 //https://leetcode.com/discuss/29921/basically-seems-merge-sort-problem-really-easy-understand
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode middle = head, end = middle.next.next;
        while(end != null && end.next != null){
            middle = middle.next;
            end = end.next.next;
        }
        if(end != null){//consider [1,2,3,4,5], [1,2,3,4]
            middle = middle.next;
        }
        ListNode head2 = middle.next;
        middle.next = null;
        return merge(sortList(head),sortList(head2));
    }
    
    //I have coded this before, but a little optimized
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null) return h2;
        if(h2 == null) return h1;
        ListNode newHead = new ListNode(-1);
        ListNode h3 = newHead;
        while(h1 != null && h2 != null){
           if(h1.val <= h2.val) {
               h3.next = h1;
               h1 = h1.next;
           } else {
               h3.next = h2;
               h2 = h2.next;
           }
           h3 = h3.next;
        }
        if(h1 != null) {
            h3.next = h1;
        }
        if(h2 != null) {
            h3.next = h2;
        }
        return newHead.next;
    }
}
