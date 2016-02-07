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

//This is my first silly answer
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3 = l1;
                l1 = l1.next;
            } else {
                l3 = l2;
                l2 = l2.next;
            }
        }
        
        ListNode tmp = l3;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        while(l1 != null){
            tmp.next = l1;
            tmp = tmp.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            tmp.next = l2;
            tmp = tmp.next;
            l2 = l2.next;
        }
        
        return l3;
    }
}
