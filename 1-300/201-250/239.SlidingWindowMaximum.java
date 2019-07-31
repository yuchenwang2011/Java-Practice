239. Sliding Window Maximum
Hard
Given an array nums, there is a sliding window of size k 
which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. 
Each time the sliding window moves right by one position. Return the max sliding window.

Example:
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 

Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
Could you solve it in linear time?

Answer:
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) return new int[0];
        int[] result = new int[nums.length - (k - 1)];
        //这里其实用LinkedList都可以
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            //4最后写这一行
            //here means it's time to change a bracket, so need to remove the first element, if it's still not yet removed by 2nd while
            if(!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            //2再写这一行
            //就跟猴子摘玉米似的，就是里面的小元素全都不要了，就要大的
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            //1先写这一行
            dq.offer(i);

            //3再写这行，为什么i - k + 1呢，因为result.length是n - k + 1啊
            //同时假如k == 2，就是意味着当i == 2 的时候，也就是第三个数，第一个bracket成型的时候，就更新result了
            if(i - k + 1>= 0) {
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }
}
