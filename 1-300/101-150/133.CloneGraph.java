133. Clone Graph   My Submissions QuestionEditorial Solution
Total Accepted: 65596 Total Submissions: 263609 Difficulty: Medium
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
              
              
              
New version of question:

133. Clone Graph
Medium

Given a reference of a node in a connected undirected graph, 
return a deep copy (clone) of the graph. Each node in the graph 
contains a val (int) and a list (List[Node]) of its neighbors.

Example:
1--2
|  |
4--3

Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 

Note:

The number of nodes will be between 1 and 100.
The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
You must return the copy of the given node as a reference to the cloned graph.
         
Answer:
(这个defination后来改动变更方便了)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

//DFS
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        helper(node, map);
        return map.get(node);
    }
    
    public void helper(Node node, Map<Node, Node> map){
        Node node2 = new Node(node.val, new ArrayList<>());
        map.put(node, node2);
        for(Node nei: node.neighbors){
            if(!map.containsKey(nei)) {
                helper(nei, map);
            }
            node2.neighbors.add(map.get(nei));
        }
    }
}

//BFS
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            Node tmp2 = map.get(tmp);
            for(Node nei : tmp.neighbors){
                if(!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val, new ArrayList<>()));
                    queue.offer(nei);
                }
                tmp2.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}
