1171. Remove Zero Sum Consecutive Nodes from Linked List
Medium

Given the head of a linked list, we repeatedly delete consecutive sequences of nodes 
that sum to 0 until there are no such sequences.
After doing so, return the head of the final linked list.  You may return any such answer.

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:
Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.

Example 2:
Input: head = [1,2,3,-3,4]
Output: [1,2,4]

Example 3:
Input: head = [1,2,3,-3,-2]
Output: [1]
 
Constraints:
The given linked list will contain between 1 and 1000 nodes.
Each node in the linked list has -1000 <= node.val <= 1000.
Accepted 1,220 Submissions 3,321

Hint:
1.Convert the linked list into an array.
2.While you can find a non-empty subarray with sum = 0, erase it.
3.Convert the array into a linked list.

Answer:
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        while(head != null && head.val == 0){
            head = head.next;
        }
        if(head == null || head.next == null) return head;
        
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode tmp = head.next;
        int val = head.val;
        map.put(val, head);
        
        while(tmp != null){
            val += tmp.val;
            if(val == 0) {
                head = tmp.next;
            } else if (map.containsKey(val)){
                //意味着上次出现val以后，之间的数字加起来是0，所以才没增没减
                map.get(val).next = tmp.next;
            } else {
                map.put(val, tmp);
            }
            tmp = tmp.next;
        }
        return head;
    }
}
