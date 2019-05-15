80. Remove Duplicates from Sorted Array II My Submissions Question
Total Accepted: 64096 Total Submissions: 201688 Difficulty: Medium
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, 
with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.

Answer:
//this is my second round solution
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        int size = 1, times = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]) {
                nums[size++] = nums[i];
                times = 1;
            } else {
                if(++times <= 2) nums[size++] = nums[i];
            }
        }
        return size;
    }
}


//may14 2019 from the video
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int result = 2;
        if(nums.length <= 2) return result;
        
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[result - 2]) {
                nums[result++] = nums[i];
            }
        }
        return result;
    }
}
