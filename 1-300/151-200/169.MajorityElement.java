169. Majority Element My Submissions Question
Total Accepted: 86214 Total Submissions: 220633 Difficulty: Easy
Given an array of size n, find the majority element. 
The majority element is the element that appears more than n/2 times.
You may assume that the array is non-empty and the majority element always exist in the array.

Answer:
class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 1;
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == result) {
                count++;
            } else if (nums[i] != result){
                count--;
            } 
            if (count == 0){
                result = nums[i];
                count++;
            }
        }
        return result;
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0) return Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
                continue;
            }
            map.put(nums[i], 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > nums.length/2) return key;
        }
        return nums[0];
    }
}
