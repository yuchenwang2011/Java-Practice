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
public class Solution {
    public int removeDuplicates(int[] nums) {
        int size = 0; int duplicateCount = 0;
        if(nums == null || nums.length ==0){
            return size;
        }

        for(int i =0; i < nums.length; i++){
            if(nums[i] != nums[size]){
                   nums[++size] = nums[i]; 
                   duplicateCount=0;
            } else if (i > 0 && nums[i] == nums[size]){
                duplicateCount++;
                if(duplicateCount < 2){
                    nums[++size] = nums[i]; 
                }
            }
        }
        return size+1;
    }
}

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
