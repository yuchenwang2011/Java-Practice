301. Remove Invalid Parentheses
Hard

Remove the minimum number of invalid parentheses 
in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]

Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]

Example 3:
Input: ")("
Output: [""]

Accepted 137,043 Submissions 343,209

Answer:
//DFS roughly O(nk). Accurately O(nm) where m is the total "number of recursive calls" 
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        helper(s, result, 0, 0, '(', ')');
        return result;
    }
    
    public void helper(String s, List<String> result, int iStart, int jStart, char openP, char closeP){
        int count1 = 0;
        int count2 = 0;
        for(int i = iStart; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == openP) count1++;
            if(c == closeP) count2++;
            if(count1 < count2) {
                for(int j = jStart; j <= i; j++){
                    //要么就是起始位，要么就是前一位跟现在不一样，才能删除。因为我们总删除第一个出现的反括号
                    //要是前面一位就已经是反括号了，那就应该删除前面那一位啊
                    //注意不能==openP，必须是!=closeP，因为有字母
                    if(s.charAt(j) == closeP && (j == jStart || s.charAt(j - 1) != closeP)) {
                        String newS = s.substring(0, j) + s.substring(j + 1);
                        helper(newS, result, i, j, openP, closeP);
                    }
                }
                return;
            }
        }
        String reverseS = new StringBuilder(s).reverse().toString();
        if(openP == '(') {
            helper(reverseS, result, 0, 0, closeP, openP);
        } else {
            result.add(reverseS);
        }
    }
}

Explanation:
We all know how to check a string of parentheses is valid using a stack. Or even simpler use a counter.
The counter will increase when it is ‘(‘ and decrease when it is ‘)’. 
  Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.

To make the prefix valid, we need to remove a ‘)’. The problem is: which one? 
  The answer is any one in the prefix. However, if we remove any one, 
we will generate duplicate results, for example: s = ()), we can remove s[1] or s[2] 
but the result is the same (). Thus, we restrict ourself to remove the first ) in a series of concecutive )s.

After the removal, the prefix is then valid. We then call the function recursively 
to solve the rest of the string. However, we need to keep another information: 
the last removal position. If we do not have this position, 
we will generate duplicate by removing two ‘)’ in two steps only with a different order.
For this, we keep tracking the last removal position and only remove ‘)’ after that.

Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
The answer is: do the same from right to left.
However a cleverer idea is: reverse the string and reuse the code!
                                                                                
The program only generates valid answers. Every path in the search generates one valid answer. 
The whole search space is a tree with k leaves. The number of nodes in the tree is roughly O(k). 
But this is not always true, for example a degenerated tree.
To generate one node it requires O(n) time from the string concatenation among other things. 
So roughly O(nk). Accurately O(nm) where m is the total "number of recursive calls" 
or "nodes in the search tree". Then you need to relate m to n in the worst case.
I wouldn't worry too much about the accurate complexity analysis of this problem.
It would require more mathematics than an interview cares.
                                                                                
                                                                                
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
      List<String> res = new ArrayList<>();
      if (s == null) return res;
      
      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      
      queue.add(s);
      visited.add(s);
      
      boolean found = false;
      while (!queue.isEmpty()) {
        s = queue.poll();
        if (isValid(s)) {
          // found an answer, add to the result
          res.add(s);
          found = true;
        }
        if (found) continue;      
        // generate all possible states
        for (int i = 0; i < s.length(); i++) {
          // we only try to remove left or right paren
          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
          String t = s.substring(0, i) + s.substring(i + 1);
          if (!visited.contains(t)) {
            // for each state, if it's not visited, add it to the queue
            queue.add(t);
            visited.add(t);
          }
        }
      }
      return res;
    }
    
    boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
                                                           
On the first level, there's only one string which is the input string s, 
let's say the length of it is n, to check whether it's valid, we need O(n) time. 
On the second level, we remove one ( or ) from the first level, so there are C(n, n-1) new strings, 
each of them has n-1 characters, and for each string, we need to check whether it's valid or not, 
thus the total time complexity on this level is (n-1) x C(n, n-1). Come to the third level, 
total time complexity is (n-2) x C(n, n-2), so on and so forth...

Finally we have this formula:
T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
