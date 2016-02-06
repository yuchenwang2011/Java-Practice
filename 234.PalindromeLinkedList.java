234. Palindrome Linked List My Submissions Question
Total Accepted: 36401 Total Submissions: 136808 Difficulty: Easy
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

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
    public boolean isPalindrome(ListNode head) {
        //http://algorithm.yuanbin.me/zh-hans/linked_list/palindrome_linked_list.html
        if(head == null || head.next == null){
            return true;
        }
        ListNode first = head, second = head;
        //********Remember!!!!! second!=null must be put in front!! [1,2] will give NullPointerException
        while(second != null && second.next != null){
            second = second.next.next;
            first = first.next;
        }
        //when the list has odd nodes, such as [1,2,3,4,5], first will stop at 3 but we don't want that
        if(second != null) first = first.next;
        
        first = reverseList(first);
        while(first != null){
            if(first.val != head.val) return false;
            first = first.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
