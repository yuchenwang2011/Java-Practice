27. Remove Element My Submissions Question
Total Accepted: 95355 Total Submissions: 291850 Difficulty: Easy
Given an array and a value, remove all instances of that value in place and return the new length.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Answer: 
public class Solution {
    //the two pointer tag is really confusing, i don't get the kaodian of this question
    //the array shrink itself everytime, shrink the last one
    //when shrink, the i will stay at the current position to check if the new swapped from the end is the same as value
    //refer to the answer of https://leetcode.com/discuss/3753/my-solution-for-your-reference
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int size = nums.length;
        int i =0;
        while(i < size) {
            if(nums[i] == val){
                nums[i] = nums[size-1];
                size--;
            } else {
                i++;
            }
            
        }
        return size;
    }
}
//[1,2,2] 2 expect [1], [1,2,3] 2 expects [1,3], [4,2,0,2,2,1,4,4,1,4,3,2] 4 expects [2,2,0,2,2,1,3,1]

