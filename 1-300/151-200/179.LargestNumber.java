179. Largest Number   My Submissions QuestionEditorial Solution
Total Accepted: 44116 Total Submissions: 232604 Difficulty: Medium
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Answer:
class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "0";
        
        String[] strs = convertToString(nums);
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        String result = "";
        for(String s : strs){
            result += s;
        }
        if(result.charAt(0) == '0') return "0";
        return result;
    }
    
    private String[] convertToString(int[] nums){
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        return strs;
    }
}
