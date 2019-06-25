27. Remove Element My Submissions Question
Total Accepted: 95355 Total Submissions: 291850 Difficulty: Easy
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Answer: 
//[1,2,2] 2 expect [1], [1,2,3] 2 expects [1,3], [4,2,0,2,2,1,4,4,1,4,3,2] 4 expects [2,2,0,2,2,1,3,1]
//this is my second round answer
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length ==0) return 0;
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            if(nums[start] == val) nums[start] = nums[end--];
            else start++;
        }
        return end + 1;
    }
}

//this is my third round answer
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0] == val ? 0 : 1;
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) nums[size++] = nums[i];
        }
        return size;
    }
}
