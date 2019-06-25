86. Partition List My Submissions Question
Total Accepted: 58673 Total Submissions: 203634 Difficulty: Medium
Given a linked list and a value x, 
partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

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
    //I was wrong at first, someone solved my problem.
    //https://leetcode.com/discuss/85513/whats-wrong-with-my-answer-java-using-recursion
  public ListNode partition(ListNode head, int x) {
    if(head == null || head.next == null) return head;
    ListNode small = new ListNode(-1), big = new ListNode(-1);
    ListNode[] result = new ListNode[]{small,big};
    process(head,x,result);
    result[1].next = null;
    result[0].next = big.next;
    return small.next;
  }

public void process(ListNode head,int x, ListNode[] result){
    if(head == null) return;
    if(head.val >= x){
        result[1].next = head;
        result[1] = result[1].next;
    } else {
        result[0].next = head;
        result[0] = result[0].next;
    }
    process(head.next,x,result);
  }
}

//some changes on above solution
class Solution {
    ListNode h1 = new ListNode(-1);
    ListNode h2 = new ListNode(-1);
    
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        
        helper(h1, h2, head, x);
        return h1.next;
    }
    
    public void helper(ListNode tmp1, ListNode tmp2, ListNode head, int x){
        if(head == null) {
            tmp2.next = null;
            tmp1.next = h2.next;
            return;
        }
        if(head.val < x) {
            tmp1.next = head;
            tmp1 = tmp1.next;
        } else {
            tmp2.next = head;
            tmp2 = tmp2.next;
        }
        head = head.next;
        helper(tmp1, tmp2, head, x);
    }
}



//my own iterative solution May18 2019
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null ||head.next == null) return head;
        
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        
        ListNode tmp1 = head1;
        ListNode tmp2 = head2;
        while(head != null){
            if(head.val < x) {
                tmp1.next = head;
                tmp1 = tmp1.next;
            } else {
                tmp2.next = head;
                tmp2 = tmp2.next;
            }
            
            head = head.next;
        }
        //alert: this is a must!
        tmp2.next = null;
        tmp1.next = head2.next;
        return head1.next;
    }
}
