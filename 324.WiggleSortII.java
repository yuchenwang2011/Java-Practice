324. Wiggle Sort II   My Submissions QuestionEditorial Solution
Total Accepted: 8790 Total Submissions: 39627 Difficulty: Medium
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?

Answer:
public class Solution {
    //Got inspired by this answer, I will use the bad performance solution O(NLogN), 
    //because O(N) is too difficult, I won't be able to come up this kind of answer in a real interview
    //http://www.cnblogs.com/grandyang/p/5139057.html
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int[] result = new int[nums.length];
        Arrays.sort(nums);
        
        int start = (nums.length % 2 == 0) ? nums.length / 2 - 1 : nums.length / 2,  end = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = (i % 2 == 0) ? nums[start--] : nums[end--];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = result[i];
        }
    }
}
