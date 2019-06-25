169. Majority Element My Submissions Question
Total Accepted: 86214 Total Submissions: 220633 Difficulty: Easy
Given an array of size n, find the majority element. 
The majority element is the element that appears more than n/2 times.
You may assume that the array is non-empty and the majority element always exist in the array.

Answer:
public class Solution {
    public int majorityElement(int[] nums) {
        //inspired by the Moore Voting Algorithm
        //https://leetcode.com/discuss/66546/moore-voting-algorithm
        //There's also a devide-and-conquere method, but i don't understand, will do it next round
        int major =0, count = 0;
        for(int num : nums){
            if (count == 0) {
                major = num;
                count ++;
            } else if (count != 0) {
                if(major == num) {
                    count ++;
                } else {
                    count --;
                }
            }
        }
        return major;
    }
}

//this is my second round answer
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        int result = nums[0], votes = 1;
        for(int i = 1; i < nums.length; i++){
            if(votes == 0) {
                result = nums[i];
                votes++;
                continue;
            }
            if(nums[i] == result) votes++;
            else votes--;
        }
        return result;
    }
}

//Another solution of myself, though performance is slow
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
