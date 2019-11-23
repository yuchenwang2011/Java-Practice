21. Merge Two Sorted Lists My Submissions Question
Total Accepted: 106665 Total Submissions: 309278 Difficulty: Easy
Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Iterative Method
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode l3 = new ListNode(-1);
        ListNode newHead = l3;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        l3.next = (l1 != null) ? l1 : l2;
        return newHead.next;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
      if(l1.val <= l2.val){
          l1.next = mergeTwoLists(l1.next,l2);
          return l1;
      } else {
          l2.next = mergeTwoLists(l1,l2.next);
          return l2;
      }
    }
}
