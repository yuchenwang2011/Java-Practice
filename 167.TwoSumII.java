Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Answer:
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int id1=0; int id2=numbers.length-1;
        
        if(numbers.length>=2 && numbers!=null){
          while (id1 < id2) {
            if(numbers[id1]+numbers[id2]<target){
              id1++;
            } else if (numbers[id1]+numbers[id2]>target) {
              id2--;
            } else {
              break;
            }
          }
          result[0]=id1+1;
          result[1]=id2+1;
          return result;
        } else {
          return null;
        }
    }
}
