1207. Unique Number of Occurrences
Easy 4.1K 95

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 
Constraints:
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000

Accepted 332.2K Submissions 448.7K Acceptance Rate 74.0%

Answer:
//my own solution
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr == null || arr.length < 2) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(int i : map.values()){
            if(!set.add(i)) return false;
        }
        return true;
    }
}
