282. Expression Add Operators
Hard

Given a string that contains only digits 0-9 and a target value, 
return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:
Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:
Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:
Input: num = "3456237490", target = 9191
Output: []
Accepted 73,024 Submissions 219,881

Answer:
This problem has a lot of edge cases to be considered:

overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
a little trick is that we should save the value that is to be multiplied in the next recursion.

// Input: num = "123", target = 24
// Output: ["1+23"] 
    
// Inpuut: num = "105" target = 5
// Output: ["1*0+5","10-5"]
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            //这里注意是pos等于0，而且i不等于pos，也就是说第一位是pos，然后取几位数
            //也就是说这一段的首位是0开头的数字，所以当然是不允许的
            if(i != pos && num.charAt(pos) == '0') break;
            //就像我给的例子["1+23"]，是可以有多位的
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);         
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);     
                //比如之前的循环是1+2，所以mul是2，val是3, 结果到了下一轮，你却想1+2*3
                //那么你val就得回复原来的3-2=1了。然后mul*cur就放到下一轮的mul，以备乘法运算用
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}
