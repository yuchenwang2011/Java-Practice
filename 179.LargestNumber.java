179. Largest Number   My Submissions QuestionEditorial Solution
Total Accepted: 44116 Total Submissions: 232604 Difficulty: Medium
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Answer:
public class Solution {
    //Got inspired by this answer
    //https://leetcode.com/discuss/23422/my-java-solution-to-share
    //https://leetcode.com/discuss/76126/share-my-fast-java-solution-beat-98-64%25
    //************Remember the usage of a Comparator!!!!!!!!
    //To memorize the order of comparator, try a!!!scending is a.compareTo(b);
    //http://stackoverflow.com/questions/1946668/sorting-using-comparator-descending-order-user-defined-classes
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = nums[i] + "";
        }
        
        //or Comparator<String> comp = new Comparator<String>(){}
        //then Arrays.sort(strings, comp);
        Arrays.sort(strs, new Comparator<String>(){
           public int compare(String s1, String s2){
               String a = s1 + s2;
               String b = s2 + s1;
               return a.compareTo(b);
           } 
        });
        if(strs[strs.length - 1].charAt(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            System.out.println(strs[i]);
            sb.insert(0, strs[i]);
        }
        return sb.toString();
    }
}
