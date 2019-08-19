206. Reverse Linked List My Submissions Question
Total Accepted: 79530 Total Submissions: 210948 Difficulty: Easy
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

Answer:
//千万注意，两个方法都用到一个pre node
public class Solution {
    public ListNode reverseList(ListNode head) {
      ListNode newHead = null;
      while(head != null){
          ListNode next = head.next;
          head.next = newHead;
          newHead = head;
          head = next;   //1->2->3->4, <-1 2->3-4>, <-1<-2 3->4, <-1<-2<-3 4, <-1<-2<-3<-4 
      }
      return newHead;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        return recur(head,null);
    }
    public ListNode recur(ListNode head,ListNode newHead){
        if(head == null) {
            return newHead;
        } 
        ListNode next = head.next;
        head.next = newHead;
        return recur(next,head);
    }
}
