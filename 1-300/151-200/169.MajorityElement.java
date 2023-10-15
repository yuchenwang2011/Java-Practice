169. Majority Element My Submissions Question
Total Accepted: 86214 Total Submissions: 220633 Difficulty: Easy
Given an array of size n, find the majority element. 
The majority element is the element that appears more than n/2 times.
You may assume that the array is non-empty and the majority element always exist in the array.

Answer:
public class Solution {
    //理解就是一换一，最后人多的拼到最后还剩下了
    public int majorityElement(int[] num) {
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
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
