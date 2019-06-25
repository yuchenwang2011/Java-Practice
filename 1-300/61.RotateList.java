61. Rotate List My Submissions Question
Total Accepted: 61055 Total Submissions: 271686 Difficulty: Medium
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//This is my own idea.
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k ==0) return head;
        ListNode tmp = head;
        int count =1;
        while(tmp.next != null){
            tmp = tmp.next;
            count++;
        }
        ListNode end = tmp;
        k =k%count;
        if(k==0) return head;
        
        tmp = head;
        int switchTimes = count - k -1; //1,2,3,4,5 k=2, need switch twice from head to 3, 5-2-1=2
        while(switchTimes > 0){
            tmp = tmp.next;
            switchTimes--;
        }
        ListNode newHead = tmp.next;
        tmp.next = null;
        end.next = head;
        return newHead;
    }
}

//This is my own solution 3 years laster, May10,2019, very similar to above one
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k <= 0) return head;
        ListNode tmp = head;
        int count = 0;
        while(tmp != null){
            tmp = tmp.next;
            count++;
        }
        k = k % count;
        if(k == 0) return head;
        
        ListNode first = head;
        ListNode second = head;
        while(k > 0){
            second = second.next;
            k--;
        }

        while(second != null && second.next != null){
            first = first.next;
            second = second.next;
        }
        
        ListNode newHead = first.next;
        first.next = null;
        second.next = head;
        return newHead;
    }
}

