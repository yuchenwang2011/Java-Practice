179. Largest Number   My Submissions QuestionEditorial Solution
Total Accepted: 44116 Total Submissions: 232604 Difficulty: Medium
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Answer:
//就这么记，想正常升序排序就a.compareTo(b)。但凡是一个题稍微要懂点脑子的题，
//把变形的、打乱了两个形参顺序的b放到前面，你就需要b.compareTo(a)
class Solution {
    public String largestNumber(int[] nums) {
        String result = "";
        if(nums == null || nums.length == 0) return result;
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strings[i] = nums[i] + "";
        }
        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
        for(String string : strings){
            result += string;
        }
        if(result.charAt(0) == '0') return "0";
        return result;
    }
}
