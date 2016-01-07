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
