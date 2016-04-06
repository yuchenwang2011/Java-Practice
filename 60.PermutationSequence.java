60. Permutation Sequence My Submissions QuestionEditorial Solution
Total Accepted: 52125 Total Submissions: 208715 Difficulty: Medium
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

Answer:
public class Solution {
    //Got inspired by this answer: super patient and long explanation
    //https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in-o-n
    public String getPermutation(int n, int k) {
        //Here i just assume n and k are valid
        
        String result = "";
        //To build the factorial checkup table
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            factorial[i] = factorial[i-1] * i;
            System.out.println(factorial[i]);
        }
        
        //save all the numbers to be used for permutation, once one value is used, delete it from the list
        List<Integer> num = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            num.add(i + 1);
        }
        
        k = k - 1;
        //like the example given by the quesiton, for the first digit to be 1,2,3, each of these 3 numbers is followed 
        //by 2 combinations, so if we want the 3rd one, we need 3 / 2 = 1, means it's the second number, first digit is 2 
        for(int i = 0; i < n; i++){
            int index = k / factorial[n - i - 1]; //when n = 3, k/2 = k/factorial[2]=k/factorial[3-1]
            result = result + "" + num.get(index);
            num.remove(index);
            k = k - factorial[n - i - 1] * index; 
            //so now after first round, your question becomes give you n = n - 1, to find the k th item inside
            //and the k now is the old k - the permutations in the previous catogary
        }
        return result;
    }
}
