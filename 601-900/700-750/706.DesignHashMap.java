706. Design HashMap
Easy

Design a HashMap without using any built-in hash table libraries.
To be specific, your design should include these functions:

1. put(key, value) : Insert a (key, value) pair into the HashMap. 
If the value already exists in the HashMap, update the value.

2. get(key): Returns the value to which the specified key is mapped, 
or -1 if this map contains no mapping for the key.

3. remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:
All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.
Accepted 43,187 Submissions 75,874

Answer:
class MyHashMap {
    private ListNode[] nodes;
    public MyHashMap() {
        nodes = new ListNode[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getIdx(key);
        if(nodes[idx] == null) {
            nodes[idx] = new ListNode(-1, -1);
        }
        ListNode prev = findPrev(key);
        if(prev.next == null) prev.next = new ListNode(key, value);
        else prev.next.val = value;
    }
    
    public int get(int key) {
        ListNode prev = findPrev(key);
        if(prev == null || prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        ListNode prev = findPrev(key);
        if(prev == null || prev.next == null) return;
        prev.next = prev.next.next;
    }
    
    public ListNode findPrev(int key){
        int idx = getIdx(key);
        if(nodes[idx] == null) return null;
        ListNode prev = null;
        ListNode node = nodes[idx];
        while(node != null && node.key != key){
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    public int getIdx(int key){
        return Integer.hashCode(key) % nodes.length;
    }
    
    //I learnt this knowledge point: if outside class is package private, here you can't public
    //you need keep resistent with outside class
    class ListNode{
        int key;
        int val;
        ListNode next;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
        }
    }
}
