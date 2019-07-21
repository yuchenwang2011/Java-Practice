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

public class Solution {
    //http://www.jiuzhang.com/solutions/kth-largest-element/
    public int findKthLargest(int[] nums, int k) {
        if(k <= 0 || nums == null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    public int helper(int[] nums, int left, int right, int k){
        if(left == right) return nums[left];
        int position = partition(nums, left, right);  // the position of pivot
        if(position + 1 == k) return nums[position];
        else if (position + 1 < k) return helper(nums, position + 1, right, k);
        else return helper(nums, left, position - 1, k);
    }
    
    public int partition(int[] nums, int left, int right){
        if(left == right) return left;
        int pivot = nums[left];
        //once left == right we can already return, so break
        while(left < right){
            while(left < right && nums[right] >= pivot) right --;
            if(left < right) swap(left, right, nums);
            while(left < right && nums[left] <= pivot) left ++;
            if(left < right) swap(left, right, nums);
        } //anyway, after 撸完 one round, left side all smaller than pivot, right side all bigger than pivot
        return left;
    }
    
    public void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
