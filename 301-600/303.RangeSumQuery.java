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
public class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        sums = nums;  //this is tricky here because nums can be length == 0
        for(int i = 1; i < nums.length; i++){
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return sums[j];
        return sums[j] - sums[i -1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
