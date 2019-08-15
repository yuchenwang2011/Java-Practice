160. Intersection of Two Linked Lists My Submissions Question
Total Accepted: 61153 Total Submissions: 204081 Difficulty: Easy
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

Answer:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /*say A length = a + c, B length = b + c, after switching pointer, 
 pointer A will move another b + c steps, pointer B will move a + c more steps, 
 since a + c + b + c = b + c + a + c, it does not matter what value c is. 
 
 Pointer A and B must meet after a + c + b (b + c + a) steps. If c == 0, they meet at NULL */
 //a1 a2 c1 c2 c3 b1 b2 b3 c1 c2 c3, b1 b2 b3 c1 c2 c3 a1 a2 c1 c2 c3
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while(a != b) {
            a = a == null? headB: a.next;
            b = b == null? headA: b.next;
        }
        return a;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        int chanceA = 1;
        int chanceB = 1;

        while(a != b){
            if(a == null) {
                if(chanceA == 0) break;
                a = headB;
                chanceA--;
            } else {
                a = a.next;
            }
            
            if(b == null) {
                if(chanceB == 0) break;
                b = headA;
                chanceB--;
            } else {
                b = b.next;
            }
        }
        return a;
    }
}
