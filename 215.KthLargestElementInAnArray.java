215. Kth Largest Element in an Array My Submissions QuestionEditorial Solution
Total Accepted: 50514 Total Submissions: 153768 Difficulty: Medium
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Answer:
public class Solution {
    //The first answer uses priority queue to solve it
    //https://leetcode.com/discuss/36966/solution-explained
    //https://leetcode.com/discuss/36931/java-ac-solution-using-heap-or-priorityqueue
    //https://leetcode.com/discuss/36913/solutions-java-having-worst-time-complexity-with-explanation
    //https://leetcode.com/discuss/37959/java-priorityqueue-o-n-log-k
    //http://blog.csdn.net/pointbreak1/article/details/46657341 this one gives me some help with understanding
    public int findKthLargest(int[] nums, int k) {
        //As for priority queue, each time poll(), it will get out the first element -- the minimum value in the pq
        //From Oracle's document, each time offer, or poll, the time complexity is O(lgN)
        //so this solution is time: O(N*logN), spaec: O(k), in java, pq is min first
        //so i can say, and actually it is true, that in java, priority queue is a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]); //pq.add() is also ok
            
            if(pq.size() > k){
                //because now, the size is actually k+1, so the kth largest must not be the first one, maybe the second one
                //so remove the first element is absolutely safe
                pq.remove(); //pq.poll() is also ok
            }
        }
        return pq.peek();
    }
}
