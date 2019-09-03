163. Missing Ranges My Submissions Question
Total Accepted: 7683 Total Submissions: 27684 Difficulty: Medium
Given a sorted integer array where the range of elements are [lower, upper] inclusive, 
return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
return ["2", "4->49", "51->74", "76->99"].

Answer:
//test case [0,1,3,50,75],0,99; [2]0,2;
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(nums == null || lower > upper) return result;
        long left = (long) lower;

        for(int i = 0; i < nums.length; i++){
            if(left == nums[i]) {
                left++;
            } else if (left == nums[i] - 1) {
                result.add(left + "");
                left = (long) nums[i] + 1;
            } else if (left < nums[i]){
                result.add(left + "->" + (nums[i] - 1));
                left = (long) nums[i] + 1;
            }
        }
        
        if(left == upper) result.add(left + "");
        if(left < upper) result.add(left + "->" + upper);
        return result;
    }
}
