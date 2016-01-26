163. Missing Ranges My Submissions Question
Total Accepted: 7683 Total Submissions: 27684 Difficulty: Medium
Given a sorted integer array where the range of elements are [lower, upper] inclusive, 
return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
return ["2", "4->49", "51->74", "76->99"].

Answer:
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int higher) {
        List<String> result = new ArrayList<String>();
        if(nums == null || lower > higher){
            return result;
        }
        if(nums.length == 0){
            if(higher == lower){
              result.add(Integer.toString(lower));
            } else {
              result.add(Integer.toString(lower) + "->" + Integer.toString(higher));
            }
            return result;
        }
        //Arrays.sort(nums);
        String s = "";
        if(nums[0] != lower){
            if(nums[0] == lower+1){
                s = Integer.toString(lower);
            } else {
                s = Integer.toString(lower) + "->" + Integer.toString(nums[0]-1);
            }
            result.add(s);
        }
        for(int i =1; i < nums.length; i++){
          if(nums[i] != nums[i-1]+1){
              if(nums[i] == nums[i-1]+2){
                 s= Integer.toString(nums[i-1]+1);
              } else {
                 s= Integer.toString(nums[i-1]+1) + "->" + Integer.toString(nums[i]-1);
              }
              result.add(s);
          }
        }
        if(nums[nums.length-1] != higher){
            if(nums[nums.length-1] == higher-1){
                s = Integer.toString(higher);
            } else {
                s = Integer.toString(nums[nums.length-1]+1) + "->" + Integer.toString(higher);
            }
            result.add(s);
        }
        return result;
    }
}
//test case [0,1,3,50,75],0,99; [2]0,2;
