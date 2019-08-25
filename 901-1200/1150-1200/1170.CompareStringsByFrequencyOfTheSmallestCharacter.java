1170. Compare Strings by Frequency of the Smallest Character
Easy

Let's define a function f(s) over a non-empty string s, 
which calculates the frequency of the smallest character in s.
For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, 
where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

Example 1:
Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").

Example 2:
Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 
Constraints:
1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters.
Accepted 2,328 Submissions 3,684

Hint:
1. For each string from words calculate the leading count and store it in an array, then sort the integer array.
2. For each string from queries calculate the leading count "p" 
and in base of the sorted array calculated on the step 1 
do a binary search to count the number of items greater than "p"
	
Answer:
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        for (int i = 0; i < q.length; i++) q[i] = func(queries[i]);
        for (int i = 0; i < w.length; i++) w[i] = func(words[i]);
        Arrays.sort(w);
        int[] result = new int[q.length];

        
        for(int i = 0; i < q.length; i++){
            int start = 0;
            int end = w.length - 1;
            while(start + 1 < end){
                int mid = (end - start) / 2 + start;
                if(q[i] >= w[mid]) start = mid;
                else end = mid;
            }
            if(q[i] < w[end]) result[i] = w.length - end;
            else if(q[i] < w[start]) result[i] = w.length - start;
        }
					
        return result;
    }

    public int func(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        for (int i = 0; i < f.length; i++) {
            if (f[i] > 0) return f[i];
        }
        return 0; 
    }
}
