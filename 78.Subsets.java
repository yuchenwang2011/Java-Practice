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
