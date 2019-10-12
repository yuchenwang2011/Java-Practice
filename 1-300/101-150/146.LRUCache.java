146. LRU Cache(HashMap + Doubly LinkedList)

Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and put.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        } 
        reOrder(node);
        return node.val;
    }
    
    //we put most recent used node at tail, remove node at head;
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            node.val = value;
            reOrder(node);
        } else {
            Node newNode = new Node(key, value);
            if(capacity == 0) {
                Node tmp = head;
                head = head.next;
                //here we can't have head.prev = null; 
                //it throughs null pointer
                map.remove(tmp.key);
                capacity++;
            }
            if(head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
    
    private void reOrder(Node node){
        if(node != tail) {
            if(node == head) {
                head = head.next;
                head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = tail.next;
        }
    }
}
 
 
