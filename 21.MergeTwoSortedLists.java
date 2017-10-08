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

//This answer uses recursion, so brilliant!
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      //This will use recursion.
      //https://leetcode.com/discuss/77201/java-recursive-solution-in-6-lines
      //https://leetcode.com/discuss/53608/simple-recursive-java-solution
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      ListNode head = l1.val < l2.val? l1:l2;
      ListNode nonhead = l1.val < l2.val? l2:l1;
      head.next = mergeTwoLists(head.next,nonhead);
      return head;
    }
}

//This method you have to 想象这是一串葡萄，每次返回后面的一串
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      if(l1.val <= l2.val){
          l1.next = mergeTwoLists(l1.next,l2);
          return l1;
      } else {
          l2.next = mergeTwoLists(l1,l2.next);
          return l2;
      }
    }
}
