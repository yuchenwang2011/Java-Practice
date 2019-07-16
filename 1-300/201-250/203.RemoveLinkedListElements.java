203. Remove Linked List Elements My Submissions Question
Total Accepted: 50513 Total Submissions: 182307 Difficulty: Easy
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Answer:
//这个题最后要记住3种做法
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode iter = pre;
        while(iter != null && iter.next != null){
            if(iter.next.val == val) iter.next = iter.next.next;
            else iter = iter.next;
        }
        return pre.next;
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}


//多看了几个链表的recursion的解法，有点感悟，就是先一个if来return，其次就是处理下一个点，所以用的就是head.next = xxxx，
//因为head是我们当前的这个函数需要去做的。所以最后当然返回的肯定也是head，因为是这个函数的任务。
//所以这个函数其实做的就是 1 if处理，2 处理下一个循环所需要的input弄好了，3把return的这一轮弄好了
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        if(head.val == val) return removeElements(head.next, val);
        head.next = removeElements(head.next,val);
        return head;
    }
}
