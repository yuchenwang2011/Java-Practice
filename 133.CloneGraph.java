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
         
Answer:
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
//DFS solution:
//https://leetcode.com/discuss/26988/depth-first-simple-java-solution
public class Solution {
    //First two link is explanation of the question, 
    //https://leetcode.com/discuss/1361/graph-representation
    //https://leetcode.com/discuss/961/wrong-sample-test-cases
    
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return process(node);
    }
    
    public UndirectedGraphNode process(UndirectedGraphNode node){
        if(node == null) return null;
        if(map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for(UndirectedGraphNode neighbor : node.neighbors){
            clone.neighbors.add(process(neighbor));
        }
        return clone;
    }
    
}

//BFS
//https://leetcode.com/discuss/14969/simple-java-iterative-bfs-solution-with-hashmap-and-queue
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode resultNode = new UndirectedGraphNode(node.label);
        map.put(resultNode.label, resultNode);
        queue.offer(node);
        
        //map is used to save new cloned nodes, and queue is to save old nodes
        //each node in map will need to add all the new cloned node as new neighbor
        
        while(!queue.isEmpty()){
            UndirectedGraphNode oldNode = queue.poll();
            for(UndirectedGraphNode oldNei : oldNode.neighbors){
                if(map.containsKey(oldNei.label) == false) {
                    map.put(oldNei.label, new UndirectedGraphNode(oldNei.label));
                    queue.offer(oldNei);
                }
                //because nodes are added in pairs to map and queue, so one oldNode corresponds to one newNode
                UndirectedGraphNode newNode = map.get(oldNode.label);
                UndirectedGraphNode newNei = map.get(oldNei.label);
                newNode.neighbors.add(newNei);
            }
        }
        return resultNode;
    }
}
