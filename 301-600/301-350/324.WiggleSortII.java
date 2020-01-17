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
//有个O(n)解法，不报希望能自己想出来
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        Arrays.sort(nums);
        int mid = (nums.length - 1) / 2;
        int right = nums.length - 1;
        int[] result = nums.clone();
        int i = 0;
        while(mid >= 0 || right > (nums.length - 1) / 2){
            nums[i] = i % 2 == 0 ? result[mid--] : result[right--];
            i++;
        }
    }
}
