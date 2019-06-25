147. Insertion Sort List My Submissions Question
Total Accepted: 64110 Total Submissions: 224313 Difficulty: Medium
Sort a linked list using insertion sort.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Got inspired by this answer:
//https://leetcode.com/discuss/24663/an-easy-and-clear-way-to-sort-o-1-space
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = new ListNode(-1);
        
        ListNode prev = newHead;
        ListNode compare = head;
        
        //一次揪出来一个，像饺子擀皮前揪面似的,实际上是重新组建一个新的list, so newHead is not connected to head
        while(compare != null){
          ListNode next = compare.next;
          while(prev.next != null && prev.next.val < compare.val) prev = prev.next;
          
          compare.next = prev.next;
          prev.next = compare;
          
          //for next round
          compare = next;
          prev = newHead;
        }

        return newHead.next;
    }
}
