215. Kth Largest Element in an Array My Submissions QuestionEditorial Solution
Total Accepted: 50514 Total Submissions: 153768 Difficulty: Medium
Find the kth largest element in an unsorted array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Answer:
//O(N lg K) running time + O(K) memory
public class Solution {
    //The first answer uses priority queue to solve it
    public int findKthLargest(int[] nums, int k) {
        //From Oracle's document, each time offer, or poll, the time complexity is O(lgN)
        //so this solution is time: O(N*logN), spaec: O(k), in java, pq is min first
        //in java, priority queue is a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            pq.offer(nums[i]); //pq.add() is also ok
            
            if(pq.size() > k){
                //这么想，不用管中间过程，最后你就留下了K个最大的数，因为min在前，所以每次都把小的撸出去了
                //最后剩下k个值，肯定是k个最大的，最后你再撸一下，肯定是第k个最大的。
                pq.remove(); //pq.poll() is also ok
            }
        }
        //return pq.poll()也行
        return pq.peek();
    }
}

//O(N) best case / O(N^2) worst case running time + O(1) memory
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k <= 0 || nums == null || nums.length == 0 || k > nums.length) return 0;
        int start = 0;
        int end = nums.length - 1;
        //这里必须是true，而且true了以后最后就不需要，也不能有return statement了
        while(true){
            int pos = partition(nums, start, end);
            //k is not array index
            //反正要返回一个pivot，左边大于它，右边小于它，如果碰巧它就是k，满足条件返回呗，剩下的烂摊子不管了
            if(pos + 1 == k) return nums[pos];
            //说明左边的数还不够多，要找的k的位置在现在这个pivot position右边，所以移动左边的start
            //alert: here start must plus 1!
            else if(pos + 1 < k) start = pos + 1;
            //pos + 1 > k
            else end = pos - 1;
        }
    }
    
    public int partition(int[] nums, int start, int end){
        if(start >= end) return start;
        int pivot = nums[start];
        while(start < end){
            //从大到小quick sort
            //alert: here must first process end, second start, because we need return start at end
            while(start < end && nums[end] <= pivot) end--;
            if(start < end) swap(nums, start, end);
            while(start < end && nums[start] >= pivot) start++;
            if(start < end) swap(nums, start, end);
        }
        return start;
    }
    
    public void swap(int[] nums, int start, int end){
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}
