254. Factor Combinations   My Submissions QuestionEditorial Solution
Total Accepted: 7641 Total Submissions: 22069 Difficulty: Medium
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note: 
Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples: 
input: 1
output: 
[]
input: 37
output: 
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]

Answer:
public class Solution {
    //First answer is very easy to understand but slow.
    //https://leetcode.com/discuss/51250/my-recursive-dfs-java-solution
    //Second one is fast but hard to understand, doesn't fit my template
    //https://leetcode.com/discuss/58828/a-simple-java-solution
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n <= 3) return result;
        List<Integer> tmp = new ArrayList<Integer>();
        process(n, result, tmp, -1);
        return result;
    }
    
    public void process(int n, List<List<Integer>> result, List<Integer> tmp, int start){
        if(start != -1) {
            tmp.add(n);
            result.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size() -1 );
        }
        
        int upper = (int) Math.sqrt(n);
        int lower = Math.max(start, 2);
        
        for(int i = lower; i <= upper; i++){
            if(n % i == 0) {
                tmp.add(i);
                process(n/i, result, tmp, i);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
