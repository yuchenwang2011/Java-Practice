217. Contains Duplicate My Submissions Question
Total Accepted: 61619 Total Submissions: 155636 Difficulty: Easy
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.

Answer: 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        if(nums == null || size ==0 || size ==1) {
            return false;
        }
        
        HashSet<Integer> myHashSet = new HashSet<Integer>();
        for(int i =0; i < size ; i++) {
            if(myHashSet.add(nums[i]) == false) {
                return true;
            }
        }
        return false;
    }
}
