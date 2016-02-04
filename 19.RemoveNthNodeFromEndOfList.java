19. Remove Nth Node From End of List My Submissions Question
Total Accepted: 92534 Total Submissions: 324528 Difficulty: Easy
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Got inspired by this answer:
        //https://leetcode.com/discuss/50398/my-one-pass-solution
        ListNode first = head;
        ListNode second = head;
        int looper = 0;
        while(looper <=n-1 && second != null){
              second = second.next;
              looper++;
        }
        //[1] 1, [1,2] 1, [1,2] 2, 
        if(second ==null){
            //it means before looper equal to n, second.next already == null
            //or that means n is bigger or equal to the length of the list
            //so here is actually remove the first node
            ListNode tmp = first.next;
            first.next = null;
            return tmp;
        }
        //Now the window between first and second is n-1;
        while(second.next != null){
            second = second.next;
            first = first.next;
        }
        
        ListNode tmp = first.next.next;
        first.next.next = null;
        first.next = tmp;
        
        return head;
    }
}
