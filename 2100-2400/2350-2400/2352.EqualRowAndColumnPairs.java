2352. Equal Row and Column Pairs
Medium 1.8K 102

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

Example 1:
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]

Example 2:
Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
 
Constraints:
n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 105
Accepted 133K Submissions 180.8K Acceptance Rate 73.5%

Answer:
//same as what I thought, but they are using later Java APIs
//https://leetcode.com/problems/equal-row-and-column-pairs/solutions/2324750/java-python-3-o-n-2-codes-w-brief-explanation-and-analysis/
class Solution {
    public int equalPairs(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Map<String, Integer> map = new HashMap<>();
        for(int[] row : grid){
            map.merge(Arrays.toString(row), 1, Integer::sum);
        }
        int result = 0;
        for(int i = 0; i < grid[0].length; i++){
            int[] col = new int[grid.length];
            for(int j = 0; j < grid.length; j++){
                col[j] = grid[j][i];
            }
            result += map.getOrDefault(Arrays.toString(col), 0);
        }
        return result;
    }
}
