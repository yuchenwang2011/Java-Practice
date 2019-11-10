307. Range Sum Query - Mutable
Medium

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.

Example:
Given nums = [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
Accepted 85,242 Submissions 275,094

Answer:
//必须会的一道题Binary Index Tree
//https://www.jiuzhang.com/solution/range-sum-query-mutable/
class NumArray {
    private int[] nums;
    private int[] tree;
    
    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        tree = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        for(int j = i + 1; j < tree.length; j += lowbit(j)){
            tree[j] += diff;
        }
    }
    
    private int lowbit(int x) {
        return x & (-x);
    }

    public int sumRange(int left, int right) {
        return getPrefixSum(right) - getPrefixSum(left - 1);
    }
    
    public int getPrefixSum(int index) {
        int sum = 0;
        for (int i = index + 1; i > 0; i = i - lowbit(i)) {
            sum += tree[i];
        }
        return sum;
    }
}
