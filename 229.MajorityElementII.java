229. Majority Element II My Submissions Question
Total Accepted: 20294 Total Submissions: 82045 Difficulty: Medium
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:
How many majority elements could it possibly have?

Answer: 
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //this quesiton lets me understand that when if and else if conditions both true, carry out the first one
        //Still using Moore Voting Algorithm
        //https://leetcode.com/discuss/69126/concise-java-solution-based-on-moores-voting-algorithm
        List<Integer> result = new ArrayList<Integer>();
        if (nums.length == 0 || nums == null) {
            return result;
        }
        int num1 = nums[0]; int num2 = nums[0]; //actually they can be initiated as whatever
        int count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num1){
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else { //since neither candidate matches
                count1--;
                count2--;
            }
        }
        
        count1=0;count2=0;
        for (int i = 0; i < nums.length ; i++){
            if(nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }
        
        if(count1 > nums.length/3) {result.add(num1);}
        if(count2 > nums.length/3) {result.add(num2);}
        return result;
    }
}
