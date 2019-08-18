378. Kth Smallest Element in a Sorted Matrix
Medium

Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.
  
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.

Accepted 121,570 Submissions 241,389

Answer:
//两种方法都需要掌握
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) return k;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++){
            pq.offer(new Node(0, i, matrix[0][i]));
        }
        for(int i = 0; i < k - 1; i++){
            Node node = pq.poll();
            if(node.x == matrix[0].length - 1) continue;
            pq.offer(new Node(node.x + 1, node.y, matrix[node.x + 1][node.y]));
        }
        return pq.poll().val;
    }
    
    public class Node implements Comparable<Node>{
        int x;
        int y;
        int val;
        
        public Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Node b){
            return this.val - b.val;
        }
    }
}
