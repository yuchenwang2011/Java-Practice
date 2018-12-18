1. Two Sum My Submissions Question
Total Accepted: 176716 Total Submissions: 862269 Difficulty: Medium
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers 
(both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Answer:
//hashtable operations are all O(1) complexity and the space complexity is O(N)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Inspired by this method
        //https://leetcode.com/discuss/8150/accepted-java-o-n-solution
        HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();
        int[] result = new int[2];
        if(nums == null || nums.length < 2){
            return result;
        }
        for(int i = 0; i< nums.length; i++){
            if(myMap.containsKey(target-nums[i])){
                result[1] = i+1;
                result[0] = myMap.get(target-nums[i])+1;
            }
            myMap.put(nums[i],i); //this has to be put in the end because possible same elements
        }
        return result;
    }
}


=============================
JavaScript Solution:
/**
    * @param {number[]} nums
    * @param {number} target
    * @param {number[]}
*/
var twoSum = function(nums, target){
    var result = [];
    
    for(var i = 0; i < nums.length - 1; i++){
        for(var j = i + 1; j < nums.length; j++){
            if(nums[i] + nums[j] == target) {
                result.push(i,j);
            }
        }
    }
        
    return result;
};


two answers below are inspired by this
https://leetcode.com/problems/two-sum/discuss/147/My-Simple-Javascript-Solution
/**
    * @param {number[]} nums
    * @param {number} target
    * @param {number[]}
*/
var twoSum = function(nums, target){
    var result = [];
    var exist = [];
    
    for(var i = 0; i < nums.length; i++){
        var diff = target - nums[i];
        if(typeof(exist[diff]) !== 'undefined'){
           result.push(exist[diff],i);
        }
        exist[nums[i]] = i;
    }
    
    return result;
};


var twoSum = function(nums, target) {
    var result = [];
    
    nums.forEach(function(num,i){
        var diff = target - num;
        var j = nums.indexOf(diff);
        if(j > -1 && j !== i){
            result[0] = i;
            result[1] = j;
            return true;
        }
    });
    
    
    return result;
};
