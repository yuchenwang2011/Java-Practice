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
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        reorder(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).val = value;
            reorder(map.get(key));
        } else {
            Node node = new Node(key, value);
            if(capacity == 0) {
                map.remove(head.key);
                head = head.next;
                if(head != null) head.pre = null;
                capacity++;
            }
            
            if(head == null && tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = tail.next;
            }
            map.put(key, node);
            capacity--;
        }
    }
    
    public void reorder(Node node){
        if(node == tail) return;
        
        if(node == head) {
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        tail.next = node;
        node.pre = tail;
        node.next = null;
        tail = tail.next;
    }
}
