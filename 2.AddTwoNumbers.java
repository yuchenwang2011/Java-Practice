2. Add Two Numbers My Submissions Question
Total Accepted: 119391 Total Submissions: 539688 Difficulty: Medium
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//This question needs practise a few times because it's the basic!
public class Solution {
    //Got inspired by this answer:
    //https://leetcode.com/discuss/2308/is-this-algorithm-optimal-or-what
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        int sum = 0;
        while(l1 != null || l2 != null) {
            sum = sum/10;
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            tmp.next = new ListNode(sum%10);
            tmp = tmp.next;
        } 
        if(sum/10 == 1){
            tmp.next = new ListNode(1);
        }
        return newHead.next;
    }
}
