328. Odd Even Linked List My Submissions Question
Total Accepted: 11933 Total Submissions: 31513 Difficulty: Easy
Given a singly linked list, group all odd nodes together followed by the even nodes. 
Please note here we are talking about the node number and not the value in the nodes.
You should try to do it in place. 
The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

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
    public ListNode oddEvenList(ListNode head) {
       //This answer is inspired by this
       //https://leetcode.com/discuss/80315/simple-o-n-time-o-1-space-java-solution
       if(head == null || head.next == null) return head;
       ListNode odd = head, even = head.next, evenHead = even;
       while(even != null && even.next != null){
           odd.next = odd.next.next;
           odd = odd.next;
           
           even.next = even.next.next;
           even = even.next;
       }
       odd.next = evenHead;
       return head;
    }
}
