43. Multiply Strings My Submissions Question
Total Accepted: 57150 Total Submissions: 247498 Difficulty: Medium
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

Answer:
public class Solution {
    //Got inspired by first answer, but it's a little not clear, so refer second answer as well
    //https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation
    //https://leetcode.com/discuss/33951/ac-solution-in-java-with-explanation
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() ==0 || num2 == null || num2.length() == 0) return "0";
        int m = num1.length(); int n = num2.length();
        int[] sum = new int[m+n];
        
        //i for num2, j for num1
        for(int i = n-1; i >= 0 ; i--){
            for(int j = m-1; j >= 0; j--){
                int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                int position1 = i + j; int position2 = i + j +1;
                //do the calculation
                int tmp = mul + sum[position2];
                sum[position2] = tmp % 10;
                sum[position1] = sum[position1] + tmp / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : sum){
            if( !(sb.length() == 0 && i == 0)) sb.append(i); //want to avoid the case, where first digit of sum is 0
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

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
