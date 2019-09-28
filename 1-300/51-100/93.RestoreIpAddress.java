93. Restore IP Addresses My Submissions Question
Total Accepted: 53092 Total Submissions: 229676 Difficulty: Medium
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

Answer:
public class Solution {
    public List<String> restoreIpAddresses(String str) {
        List<String> result = new ArrayList<String>();
        if(str == null || str.length() < 4 || str.length() > 12) return result;
        process(str, result, 0, 0, "");
        return result;
    }
    
    public void process(String str, List<String> result, int idx, int count, String tmp){
        if(count == 4 && idx == str.length() ) {
            result.add(tmp);
            return;
        }
        
        for(int i = 1; i <=3 ; i++){
            if(idx + i > str.length()) break;
            String s = str.substring(idx, idx + i);
            //["0.10.0.0"], ["0.0.0.0"], only 1 zero at beginning is allowed, so when first element is 0, length must be 1 to be valid
            if(s.charAt(0)=='0' && s.length() > 1 || Integer.parseInt(s) >= 256) continue;
            process(str, result, idx + i, count + 1, tmp + s + (count == 3 ? "" : "."));
        }
        
    }
}

//my answer sep 28 2019
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12) return result;
        helper(result, s, "", 0, 0);
        return result;
    }
    
    public void helper(List<String> result, String s, String tmp, int idx, int count){
        if(count == 4 && idx == s.length()) {
            result.add(tmp);
            return;
        }
        
        for(int i = idx; i < idx + 3; i++){
            if(i >= s.length()) break;
            String str = s.substring(idx, i + 1);
            if(Integer.valueOf(str) > 255) continue;
            if(str.length() > 1 && str.charAt(0) == '0') break;
            helper(result, s, count == 3 ? tmp + str: tmp + str + ".", i + 1, count + 1);
        }
    }
}
