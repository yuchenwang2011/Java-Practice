31. Next Permutation My Submissions Question
Total Accepted: 56459 Total Submissions: 218809 Difficulty: Medium
Implement next permutation, which rearranges numbers into 
the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it
 as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column 
and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

Answer:
//0125330-->0135320-->0130235
//https://github.com/yuchenwang2011/Java-Practice/blob/master/31.NextPermutation.png
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        boolean possible = false;
        int start = 0;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]) {
                possible = true;
                start = i - 1;
                break;
            }
        }
        if(possible) {
            for(int i = nums.length - 1; i >= start; i--){
                if(nums[i] > nums[start]) {
                    int tmp = nums[start];
                    nums[start] = nums[i];
                    nums[i] = tmp;
                    start++;
                    //break; the break is not necessary because this is a sorted interval now
                }
            }
        }
        reverseArray(nums, start, nums.length - 1);
    }
    
    public void reverseArray(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
