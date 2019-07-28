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
//两种方法，必须掌握。另外的用stack的方法我给删了
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode first = head;
        ListNode second = head;
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        
        if(second != null) first = first.next;
        first = reverse(first);
        while(first != null){
            if(head.val != first.val) return false;
            head = head.next;
            first = first.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head){
        if(head == null) return head;
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            
            prev = head;
            head = next;
        }
        return prev;
    }
}

class Solution {
    private ListNode node;
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        node = head;
        return helper(head);
    }
    
    public boolean helper(ListNode head){
        if(head == null) return true;
        boolean result = helper(head.next);
        
        if(result == true){
            if(head.val != node.val) result = false;
            else node = node.next;
        }
        return result;
    }
}
