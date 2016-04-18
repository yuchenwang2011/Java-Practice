47. Permutations II   My Submissions QuestionEditorial Solution
Total Accepted: 68663 Total Submissions: 245856 Difficulty: Medium
Given a collection of numbers that might contain duplicates, 
return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

Answer:
public class Solution {
    //Got inspired by this answer:
    //http://www.jiuzhang.com/solutions/permutations-ii/
    //https://leetcode.com/discuss/73856/really-easy-solution-easier-than-solutions-with-very-high-vote
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(nums); //very important
        boolean[] visited = new boolean[nums.length];
        process(nums, result, tmp, visited);
        return result;
    }
    
    public void process(int[] nums, List<List<Integer>> result, List<Integer> tmp, boolean[] visited){
        if(tmp.size() == nums.length) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            //Test case: [1,1], here it's hard to understand, use another test case 1,2,2
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1] ) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            process(nums, result, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}
