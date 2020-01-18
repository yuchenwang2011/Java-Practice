331. Verify Preorder Serialization of a Binary Tree   My Submissions QuestionEditorial Solution
Total Accepted: 10265 Total Submissions: 32439 Difficulty: Medium
One way to serialize a binary tree is to use pre-order traversal. 
When we encounter a non-null node, we record the node's value. 
If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", 
where # represents a null node.

Given a string of comma separated values, verify 
whether it is a correct preorder traversal serialization of a binary tree. 
Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, 
for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/83819/java-intuitive-22ms-solution-with-stack
    //1. 数字的个数总是比#号少一个 2. 最后一个一定是#号
    //将元素压入栈, 如果当前栈的深度≥3，并且最顶端两个元素为'#
    //'#'，而第三个元素不为'#'，则将这三个元素弹出栈顶，然后向栈中压入一个'#'，重复此过程
    //最后判断栈中剩余元素是否只有一个'#'
    //想象一个泡泡龙的游戏，一个节点B，左child是＃，当发现右child是＃以后，咚一下这三个就炸了
    //剩下的坑用＃补上，然后B的parentA节点，A的右child也发现是个＃，然后咚一下这三个右炸了
    //最后的root也炸了，然后用一个＃补上了。最终整个stack就剩下一个＃
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) return false;
        if(preorder.length() == 1 && preorder.charAt(0) == '#') return true;
        Deque<String> stack = new ArrayDeque<>();
        String[] nodes = preorder.split(",");
        for(String node : nodes){
            while(stack.size() != 0 && node.equals("#") && stack.peek().equals("#")){
                stack.pop();
                if(stack.size() == 0) return false;
                stack.pop();
            }
            stack.push(node);
        }
        return stack.size() == 1 ? stack.peek().equals("#") : false;
    }
}
