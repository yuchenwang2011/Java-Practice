1762. Buildings with An Ocean View
Medium
There are n buildings in a line. You are given an integer array heights of size n 
that represents the heights of the buildings in the line.
The ocean is to the right of the buildings. A building has an ocean view 
if the building can see the ocean without obstructions. Formally, a building has an ocean view 
if all the buildings to its right have a smaller height.
Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

Example 1:
Input: heights = [4,2,3,1]
Output: [0,2,3]
Explanation: Building 1 (0-indexed) does not have an ocean view because building 2 is taller.

Example 2:
Input: heights = [4,3,2,1]
Output: [0,1,2,3]
Explanation: All the buildings have an ocean view.
  
Example 3:
Input: heights = [1,3,2,4]
Output: [3]
Explanation: Only building 3 has an ocean view.

Constraints:
1 <= heights.length <= 105
1 <= heights[i] <= 109

Accepted 200.2K Submissions 251.7K Acceptance Rate 79.5%

Answer:
//https://leetcode.com/problems/buildings-with-an-ocean-view/solutions/1123778/java-trick-is-to-traverse-from-right-to-left/
class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int tall = Integer.MIN_VALUE;
        for(int i = heights.length - 1; i >= 0; i--){
            if(heights[i] > tall) {
                list.add(i);
                tall = heights[i];
            }
        }

        int[] result = new int[list.size()];
        for(int i = list.size() - 1; i >= 0; i--){
            result[list.size() -1 - i] = list.get(i);
        }
        return result;
    }
}
