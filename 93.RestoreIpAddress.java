93. Restore IP Addresses My Submissions Question
Total Accepted: 53092 Total Submissions: 229676 Difficulty: Medium
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

Answer:
public class Solution {
    //I will try to copy the 3 answers one by one
    //https://leetcode.com/discuss/15098/very-simple-dfs-solution
    //https://leetcode.com/discuss/12790/my-code-in-java
    //https://leetcode.com/discuss/19296/my-concise-ac-java-code
    public List<String> restoreIpAddresses(String str) {
        List<String> result = new ArrayList<String>();
        if(str == null || str.length() < 4 || str.length() > 16) return result;
        process(str, result, 0, 0, "");
        return result;
    }
    
    public void process(String str, List<String> result, int idx, int count, String tmp){
        if(count == 4 && idx == str.length() ) {
            result.add(tmp);
            return;
        }
        if(count > 4 || idx > str.length()) return;
        
        for(int i = 1; i <=3 ; i++){
            if(idx + i > str.length()) break;
            String s = str.substring(idx, idx + i);
            //["0.10.0.0"], ["0.0.0.0"], only 1 zero at beginning is allowed, so when first element is 0, length must be 1 to be valid
            if(s.charAt(0)=='0' && s.length() > 1 || Integer.parseInt(s) >= 256) continue;
            process(str, result, idx + i, count + 1, tmp + s + (count == 3 ? "" : "."));
        }
        
    }
}
