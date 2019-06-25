2. Add Two Numbers My Submissions Question
Total Accepted: 119391 Total Submissions: 539688 Difficulty: Medium
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//This question needs practise a few times because it's the basic!
public class Solution {
    //Got inspired by this answer:
    //https://leetcode.com/discuss/2308/is-this-algorithm-optimal-or-what
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        int sum = 0;
        while(l1 != null || l2 != null) {
            sum = sum/10;
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            tmp.next = new ListNode(sum%10);
            tmp = tmp.next;
        } 
        if(sum/10 == 1){
            tmp.next = new ListNode(1);
        }
        return newHead.next;
    }
}

//This is my answer second round
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return null;
        ListNode newHead = new ListNode(-1);
        ListNode head = newHead;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            newHead.next = new ListNode(sum % 10);
            newHead = newHead.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            
        }
        if(carry != 0) {
            newHead.next = new ListNode(carry);
        }
        return head.next;
        
    }
}

//This is my third round solution, not beautiful but easier to understand
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        
        ListNode result = new ListNode(0);
        ListNode head = result;
        
        int val = 0;
        int digit = 0;
    
        while(l1 != null && l2 != null){
            val = (l1.val + l2.val + digit) % 10;
            digit = (l1.val + l2.val + digit) / 10;
            head.next = new ListNode(val);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode tmp = l1 == null ? l2 : l1;
        while(tmp != null){
            val = (tmp.val + digit) % 10;
            digit = (tmp.val + digit) / 10;
            head.next = new ListNode(val);
            head = head.next;
            tmp = tmp.next;
        }
        
        if(digit != 0) head.next = new ListNode(digit);
        
        return result.next;
    }
}


//This is my Javascript answer
//inspired by this answer
//https://leetcode.com/problems/add-two-numbers/discuss/1020/Javascript-solution
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    if(l1 === null && l2 === null) return null;
    var result = new ListNode(-1);
    var head = result;
    
    var sum = 0;
    var carry = 0;
    while(l1 !== null || l2 !== null){
          if(l1 !== null) {
            sum += l1.val;
            l1 = l1.next;
          }
          if(l2 !== null) {
              sum += l2.val;
              l2 = l2.next;
          }
          sum += carry;
        
          if(sum >= 10) {
              carry = 1;
          }
        
          head.next = new ListNode(sum%10);
          head = head.next;
          
          sum = carry;
          carry = 0;
          
    }
    if(sum/10 !== 0) head.next = new ListNode(1);
    
    return result.next;
};
