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
public class Solution {
    public void nextPermutation(int[] nums) {
       //I was inspired by this solution:
       //https://leetcode.com/discuss/72050/readable-code-without-confusing-i-j-and-with-explanation
       //0125330-->0135320-->0130235
       if(nums == null || nums.length ==0){
           return;
       }
       int start = 0; boolean possible = false;
       for(int i = nums.length-1; i >=0 ; i--){
           if(i > 0 && nums[i-1] >= nums[i]){
               continue;
           } else if (i> 0 && nums[i-1] < nums[i]) {
               start = i-1;
               possible = true;
               break;
           }
       }
       int end = nums.length-1;
       if(possible == true){
         for(int i = nums.length-1; i > start; i--){
             if(nums[i] > nums[start]){
                 end = i;
                 break;
             }
         }
         int tmp = nums[start];
         nums[start] = nums[end];
         nums[end] = tmp;
         start++; //for next reverse step
         end = nums.length-1;
       }
       //Now all the elements after nonDescentElementIdx are decreasing order, just reverse them
       while(start <= end){
           int tmp = nums[start];
           nums[start] = nums[end];
           nums[end] = tmp;
           start++;end--;
       }
    }
}
