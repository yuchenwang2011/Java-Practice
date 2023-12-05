75. Sort Colors My Submissions Question
Total Accepted: 85495 Total Submissions: 251688 Difficulty: Medium
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

Answer:
//Here is the code I wrote in Second Round
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int zeros = 0, twos = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = nums[zeros];
                nums[zeros++] = 0;
            } else if (nums[i] == 2 && twos > i) {
                nums[i] = nums[twos];
                nums[twos--] = 2;
                i--;
            }
        }
    }
}

//update on May13 2019
//I totally don't understand my own answer above, here is my new answer
class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        
        //must has == end case
        while(i <= end){
            if(i >= start && nums[i] == 0) {
                nums[i] = nums[start];
                nums[start++] = 0;
            } else if(nums[i] == 2){
                nums[i] = nums[end];
                nums[end--] = 2;
            } else {
                i++;
            }
        }
    }
}

//update on 2023/10/15
//I can't understand my previous two solutions, here is from the discussion
//https://leetcode.com/problems/sort-colors/solutions/3464652/beats-100-c-java-python-javascript-two-pointer-dutch-national-flag-algorithm/
class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        while(mid <= end){
            if(nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                nums[mid] = nums[end];
                nums[end--] = 2;
            } else {
                nums[mid++] = nums[start];
                nums[start++] = 0;
            }
        }
    }
}
