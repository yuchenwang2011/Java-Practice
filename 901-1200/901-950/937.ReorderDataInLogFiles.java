937. Reorder Data in Log Files
Easy


You have an array of logs.  Each log is a space delimited string of words.
For each log, the first word in each log is an alphanumeric identifier. Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  
It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  
The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  
The digit-logs should be put in their original order.

Return the final order of the logs.

Example 1:
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 
Constraints:
0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.

Accepted 66,461 Submissions 123,269

Answer:
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0) return new String[0];
        Comparator comparator = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String[] stringA = a.split(" ");
                String[] stringB = b.split(" ");
                char c = stringA[1].charAt(0);
                char d = stringB[1].charAt(0);
                if(Character.isDigit(c) && !Character.isDigit(d)) {
                    return 1;
                } else if(!Character.isDigit(c) && Character.isDigit(d)) {
                    return -1;
                } else if(Character.isDigit(c) && Character.isDigit(d)){
                    return 0;
                }
                else {
                    String e = a.substring(a.indexOf(" ") + 1);
                    String f = b.substring(b.indexOf(" ") + 1);
                    if(!e.equals(f)) return (e + f).compareTo(f + e);
                    if(stringA[0].compareTo(stringB[0]) != 0) return stringA[0].compareTo(stringB[0]);
                    return 0;
                }
            }
        };
        Arrays.sort(logs, comparator);
        return logs;
    }
}
