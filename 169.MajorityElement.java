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
