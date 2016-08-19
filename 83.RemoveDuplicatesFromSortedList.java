83. Remove Duplicates from Sorted List My Submissions Question
Total Accepted: 99132 Total Submissions: 275482 Difficulty: Easy
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
//There is another 3 line elegant solution, but i don't understand
//https://leetcode.com/discuss/37323/3-line-java-recursive-solution
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }
        ListNode tmp = head;
        while(tmp.next != null){
            if(tmp.val == tmp.next.val){
                ListNode tmp2 = tmp.next;
                tmp.next = tmp.next.next;
                tmp2.next = null;
            } else {
                tmp = tmp.next;
            }
        }
        return head;
    }
}

//Recursion
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val? head.next : head;
        //It's better to draw the picture of layers, and remember the head in return, it's last one's next
    }
}

//***Finally I understand why first return case has head.next == null, it's for 2 reasons
//1st: for the 1st iteration, [1], just 1 element, so you want to return head directly
//2nd: if the current head is the end of list, so head.next = delete(null) = null; it's ok here, but later, you need to compare
//head.val and head.next.val, but null doesn't have null.val, it will return a nullPointer exception.
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val){
            head = head.next;
        }
        return head;
    }
}

//Moving the while condition to the from will be much more easier to understand
public class Solution {
     public ListNode deleteDuplicates(ListNode head) {
         if(head == null || head.next == null) return head;
         while(head.next != null && head.val == head.next.val){
             head = head.next;
          }
         head.next = deleteDuplicates(head.next);
         return head;
     }
 }

//My fourth round solution, I feel it can be more easier to understand
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        if(head.val == head.next.val) return deleteDuplicates(head.next);
        head.next = deleteDuplicates(head.next);
        return head;
    }
}
