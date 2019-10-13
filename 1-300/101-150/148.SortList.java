148. Sort List My Submissions Question
Total Accepted: 64007 Total Submissions: 265966 Difficulty: Medium
Sort a linked list in O(n log n) time using constant space complexity.

Answer:
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(head2);
        return merge(h1, h2);
    }
                    
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null || h2 == null) {
            return h1 == null ? h2 : h1;
        }
        ListNode h3Backeup = new ListNode(-1);
        
        ListNode h3 = h3Backeup;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val) {
                h3.next = h1;
                h1 = h1.next;
            } else {
                h3.next = h2;
                h2 = h2.next;
            }
            h3 = h3.next;
        }
        h3.next = h1 == null? h2 : h1;
        return h3Backeup.next;
    }
}
