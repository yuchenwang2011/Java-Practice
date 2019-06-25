163. Missing Ranges My Submissions Question
Total Accepted: 7683 Total Submissions: 27684 Difficulty: Medium
Given a sorted integer array where the range of elements are [lower, upper] inclusive, 
return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
return ["2", "4->49", "51->74", "76->99"].

Answer:
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if(lower > upper) return result;
        long left = (long) lower;
        
        for(int num : nums){
            if(num == left) {
                left++;
                continue;
            } else if(left < num){
                if(left + 1 == num) {
                    result.add(String.valueOf(left));
                } else {
                    result.add(left + "->" + (num - 1));
                }
                left = (long) num + 1;
            }
        }
        if(left == upper) result.add(String.valueOf(left));
        else if(left < upper) result.add(left + "->" + (upper));
        
        return result;
    }
}
//test case [0,1,3,50,75],0,99; [2]0,2;
