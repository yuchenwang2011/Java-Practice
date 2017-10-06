119. Pascal's Triangle II My Submissions Question
Total Accepted: 63083 Total Submissions: 203586 Difficulty: Easy
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

Answer: 
public class Solution {
    public List<Integer> getRow(int rowIndex) {
      //answer of https://leetcode.com/discuss/9411/here-is-my-o-n-solution-and-the-proof
      //answer of https://leetcode.com/discuss/8364/here-is-my-brief-o-k-solution
      //loop j from back, each time a[j-1]+a[j] = b, replace a[j] with b
      //it's better to list each level and list i and j out
      List<Integer> result = new ArrayList<Integer>();
      rowIndex = Math.abs(rowIndex);
      result.add(1);
      for(int i =1; i <= rowIndex ; i++) {
          for(int j = i-1; j >= 1; j--){
             result.set(j,result.get(j-1)+result.get(j));
          }
          result.add(1);
      }
      return result;
    }
}

//Dynamic Programming Method Oct 5, 2017
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        rowIndex = Math.abs(rowIndex);
        int[] tmp = new int[rowIndex+1];
        for(int i = 0; i <= rowIndex; i++){
            for(int j = i; j >= 0; j--){
                if(j == i || j == 0) tmp[j] = 1;
                else tmp[j] = tmp[j] + tmp[j-1];
            }
        }
        for(int i : tmp) result.add(i);
        return result;
    }
}
