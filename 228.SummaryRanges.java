228. Summary Ranges My Submissions Question
Total Accepted: 33269 Total Submissions: 148894 Difficulty: Easy
Given a sorted integer array without duplicates, return the summary of its ranges.
For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Answer: 
public class Solution {
    //if the number is consecutive like 0,1,2,3, it forms a range 0->3 if not, it forms multiple range. 
    //A range can be only one number
    //**********Usage of List: http://stackoverflow.com/questions/13395114/how-to-initialize-liststring-object-in-java
    //**********Remember the syntax of Interger.toString(i)
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 0 || nums == null){
            return result;
        }

       int start = 0;
       for(int i =0; i < nums.length ; i++){
          start = i;
          while (i+1 < nums.length && nums[i+1] == nums[i]+1) {
              i++;
          }
          if(start == i) {
              result.add(nums[start] + "");
          } else {
              result.add(nums[start] + "->" + nums[i]);
          }
       }
       return result;
    }
}
