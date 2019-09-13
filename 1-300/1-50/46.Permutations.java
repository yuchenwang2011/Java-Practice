46. Permutations   My Submissions QuestionEditorial Solution
Total Accepted: 96487 Total Submissions: 271111 Difficulty: Medium
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

Answer:
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        process(nums, result, tmp, visited);
        return result;
    }
    
    public void process(int[] nums, List<List<Integer>> result, List<Integer> tmp, boolean[] visited){
        if(tmp.size() == nums.length) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            process(nums, result, tmp, visited);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}
