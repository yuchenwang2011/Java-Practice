442. Find All Duplicates in an Array
Medium

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[2,3]

Accepted 132,951 Submissions 208,515

Answer:
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length <= 1) return result; 
        
        for(int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) result.add(idx + 1);
            else nums[idx] *= -1;
        }
        
        return result;
    }
}
