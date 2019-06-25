89. Gray Code   My Submissions QuestionEditorial Solution
Total Accepted: 59039 Total Submissions: 162880 Difficulty: Medium
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, 
print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/10068/share-my-solution
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if(n == 0) {
            result.add(0);
            return result;
        }
        result.add(0);
        for(int i = 0; i < n; i++){
            int k = result.size();
            for(int j = k -1 ; j >= 0; j--){
                result.add(result.get(j) | (1 << i));
            }
        }
        return result;
    }
}
