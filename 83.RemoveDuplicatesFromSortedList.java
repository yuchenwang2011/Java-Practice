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


