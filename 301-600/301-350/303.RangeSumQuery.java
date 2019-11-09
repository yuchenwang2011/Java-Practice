303. Range Sum Query - Immutable My Submissions QuestionEditorial Solution
Total Accepted: 26155 Total Submissions: 107231 Difficulty: Easy
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.

Answer:
class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            this.nums[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        if(i > j) return 0;
        if(i == 0) return nums[j];
        return nums[j] - nums[i - 1];
    }
}
