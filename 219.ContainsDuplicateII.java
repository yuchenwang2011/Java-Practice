219. Contains Duplicate II My Submissions Question
Total Accepted: 41103 Total Submissions: 144305 Difficulty: Easy
Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the difference between i and j is at most k.

Answer: 
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       if(nums.length < 2 || nums == null || k == 0){
           return false;
       }
       
       HashMap<Integer, Integer> myHash = new HashMap<Integer, Integer>();
       for(int i = 0; i < nums.length ; i++) {
           if (myHash.containsKey(nums[i]) && (i-myHash.get(nums[i]))<=k) {
                return true;
           } 
           myHash.put(nums[i],i);
       }
       return false;
    }
}
