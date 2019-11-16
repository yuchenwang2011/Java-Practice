313. Super Ugly Number My Submissions QuestionEditorial Solution
Total Accepted: 11660 Total Submissions: 34677 Difficulty: Medium
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose 
all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of 
the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

Answer:
//必须掌握两个方法，而且第二个方法每次都要练习写一遍
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0 || primes == null || primes.length == 0) return 0;
        int[] result = new int[n];
        result[0] = 1;
        int[] index = new int[primes.length];
        
        for(int i = 1; i < result.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                min = Math.min(min, primes[j] * result[index[j]]);
            }
            result[i] = min;
            
            for(int j = 0; j < primes.length; j++){
                if(min >= primes[j] * result[index[j]]) index[j]++;
            }
        }
        return result[result.length - 1];
    }
}

//这个是O(nlogn)方法，但是实际提交结果还是慢
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0 || primes == null || primes.length == 0) return 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0; i < primes.length; i++){
            pq.offer(new Node(primes[i], 1, primes[i]));
        }
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 1; i < result.length; i++){
            result[i] = pq.peek().val;
            while(pq.peek().val == result[i]) {
                Node node = pq.poll();
                pq.offer(new Node(node.prime, node.idx + 1, node.prime * (result[node.idx])));
            }
        }
        return result[result.length - 1];
    }
    
    class Node implements Comparable<Node>{
        int prime;
        int idx;
        int val;
        public Node(int prime, int idx, int val){
            this.prime = prime;
            this.idx = idx;
            this.val = val;
        }
        
        @Override
        public int compareTo(Node that){
            return this.val - that.val;
        }
    }
}
