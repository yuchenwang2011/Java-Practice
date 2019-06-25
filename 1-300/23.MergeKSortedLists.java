23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

Solution:
============================================all 2 solutions are from this video
https://www.youtube.com/watch?v=Uz4fTr34270&t=55s
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if(lists == null || lists.length == 0) return result;
        
        List<ListNode> allNodes = new ArrayList<>();
        for(ListNode node : lists){
            while(node != null) {
                allNodes.add(node); 
                node = node.next;
            }
        }
        Collections.sort(allNodes, (a,b) -> a.val - b.val);
        result = new ListNode(-1);
        ListNode head = result;
        for(ListNode node : allNodes){
            result.next = node;
            result = result.next;
        }
        return head.next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        if(lists == null || lists.length == 0) return result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
        for(ListNode node : lists){
            if(node != null) {
                pq.add(node);
            }
        }
        result = new ListNode(-1);
        ListNode head = result;
        while(!pq.isEmpty()){
            result.next = pq.poll();
            result = result.next;
            if(result.next != null){
                pq.add(result.next);
            }
        }
        return head.next;
    }
}
