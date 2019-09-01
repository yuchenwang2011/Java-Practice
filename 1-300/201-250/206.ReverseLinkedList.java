206. Reverse Linked List My Submissions Question
Total Accepted: 79530 Total Submissions: 210948 Difficulty: Easy
Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

Answer:
//三种方法：记忆方法，头两个方法都用到一个pre node
//额外一种recursive方法就是不需要
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

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        //先把next存下来，因为后面的顺序没准变成什么样了
        ListNode next = head.next;
        //newHead只是最开始撸到末端的那个头，剩下的什么操作都用不上它
        ListNode newHead = reverseList(head.next);
        
        next.next = head;
        head.next = null;
        return newHead;
    }
}
