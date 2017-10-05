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

//The question is not super clear, so there might be a corner case, where there are three same element
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k <= 0) return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int diff = Math.abs(i - map.get(nums[i]));
                if (diff <= k) return true;
                else map.put(nums[i], i);
            } 
            map.put(nums[i], i);
        }
        return false;
    }
}
