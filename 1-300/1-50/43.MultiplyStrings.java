43. Multiply Strings My Submissions Question
Total Accepted: 57150 Total Submissions: 247498 Difficulty: Medium
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

Answer:
//Second round solution
class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "";
        int[] result = new int[num1.length() + num2.length()];
        
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                
                //must review this part!!!!!
                result[p2] += product;
                result[p1] += result[p2] / 10;
                result[p2] = result[p2] % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            if(result[i] == 0 && sb.length() == 0){
                continue;
            }
            sb.append(result[i]);
        }
        
        return sb.length() == 0?  "0" : sb.toString();
    }
}
