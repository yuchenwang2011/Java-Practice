220. Contains Duplicate III
Medium

Given an array of integers, find out whether there are two distinct indices i and j in the array 
such that the absolute difference between nums[i] and nums[j] is 
at most t and the absolute difference between i and j is at most k.

Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true

Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

Answer:
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k <= 0 || t < 0) return false;
        
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            //floor 就是找一个小于等于这个数的element
            //ceiling就是找一个大于等于这个数的element
            Long floor = set.floor((long) nums[i] + t);
            Long ceiling = set.ceiling((long) nums[i] - t);
            
            //floor是一个小于等于+t的值，但是它没准比nums[i]也小呢，那这样的话，他们之间的距离就不只是t了
            if((floor != null && floor >= nums[i]) 
              || (ceiling != null && ceiling <= nums[i])) return true; 
            
            set.add((long)nums[i]);
            
            if(i >= k) {
                //this will be used for next round, so it's just i - k
                set.remove((long)nums[i - k]);
            }
        }
        
        
        return false;
    }
}
