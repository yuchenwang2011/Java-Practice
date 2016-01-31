78. Subsets My Submissions Question
Total Accepted: 81715 Total Submissions: 270372 Difficulty: Medium
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Answer:
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //I'm inspired by this Chinese answer
        //https://leetcode.com/discuss/25696/simple-java-solution-with-for-each-loops
        //There are still some answers I don't understand, will do them next round
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        for(int i =0; i < nums.length; i++){
            int size = result.size();
            for(int j =0; j < size; j++){
                //Here it must be a new object, otherwise you just moved the tmp pointer to 
                //the object, and chaned the original object in the result
                List<Integer> tmp = new ArrayList<Integer>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        return result;
    }
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      //The second solution is inspired by these two solutions
      //https://leetcode.com/discuss/9213/my-solution-using-bit-manipulation
      //http://www.jiuzhang.com/solutions/subsets/
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      if(nums == null || nums.length ==0){
          result.add(new ArrayList<Integer>());
          return result;
      }
      Arrays.sort(nums);
      int n = nums.length;
      for(int i = 0; i < (1<<n); i++){
          List<Integer> tmp = new ArrayList<Integer>();
          for(int j = 0; j < n; j++){
              //here just to find the ith bit whether equal to 1
              //because this case it happens to be,say 101 represents {1,3} for [1,2,3]
              //here it can't be 1 because the result is 0100 something like that
              if( (i&(1<<j)) != 0){ 
                 tmp.add(nums[j]);
              }
          }
          result.add(tmp);
      }
      return result;
    }
}
