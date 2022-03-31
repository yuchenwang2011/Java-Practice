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
    //O(LgN solution as treeset sorting is O(logN) )
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k <=0 || t < 0) return false;
        
        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++){
            Long current = (long)nums[i];
            
            //this is the first number in the set that is smaller than current number
            //so if the difference between them are smaller than t, that is good
            //that is the closest number already in the set
            Long smaller = set.floor(current);
            if(smaller != null && current - smaller <= t) return true;
            
            //this is the first number in the set that is bigger than current number
            //so if the different between them are smaller than t, that is good
            Long bigger = set.ceiling(current);
            if(bigger != null && bigger - current <= t) return true;
            
            //of course you are looping through the array, you have to save every number
            //but the set only keeps k elements at most to make sure the distance between two numbers
            //are at most k
            set.add((long)nums[i]);
            if(set.size() > k){
                //for example, i, i+1, i+2, k = 2, so need to remove nums[i], which is i + 2 - k = i
                Long tmp = (long) nums[i - k];
                set.remove(tmp);
            }
        }
        
        return false;
    }
}
