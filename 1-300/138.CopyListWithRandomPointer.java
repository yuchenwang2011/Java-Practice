138. Copy List with Random Pointer
Medium

A linked list is given such that each node contains an additional 
random pointer which could point to any node in the list or null.
Return a deep copy of the list.

Example 1: see pickture
https://leetcode.com/problems/copy-list-with-random-pointer/

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 
Note:
You must return the copy of the given head as a reference to the cloned list.

Answer:
//first answer is brute force in the comment of link below
//https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/
//A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head ==  null) return head;
        Node tmp = head;
        while(tmp != null){
            Node next = tmp.next;
            Node copy = new Node();
            copy.val = tmp.val;
            
            copy.next = next;
            tmp.next = copy;
            tmp = next;
        }
        
        tmp = head;
        while(tmp != null){
            if(tmp.random != null) {
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        
        Node newHead = new Node();
        Node tmpCopy = newHead;
        tmp = head;
        
        //1 -> 1' -> 2 -> 2'
        while(tmp != null){
            Node tmpNext = tmp.next.next;
            tmpCopy.next = tmp.next;
            tmpCopy = tmpCopy.next;
            
            tmp.next = tmpNext;
            tmp = tmp.next;
        }
        return newHead.next;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node tmp = head;
        while(tmp != null){
            Node copy = new Node();
            copy.val = tmp.val;
            map.put(tmp, copy);
            tmp = tmp.next;
        }
        
        tmp = head;
        while(tmp != null){
            Node copy = map.get(tmp);
            copy.next = map.get(tmp.next);
            copy.random = map.get(tmp.random);
            tmp = tmp.next;
        }
        return map.get(head);
    }
}
